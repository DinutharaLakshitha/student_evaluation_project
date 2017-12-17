/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attr;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utill.DbConnector;

/**
 *
 * @author rajitha
 */
public class Interviewer {
    public boolean registerInterviewer(String user_name, String occupation, String tel, String pass, String email,String school_id) throws IOException, SQLException {

        boolean success = false;
        DbConnector db;
        Connection con = null;
        try {
            db = new DbConnector();
            con = db.getCon();
            con.setAutoCommit(false);
            
            String rawString = "INSERT INTO user (user_name,pass,telephone,email) VALUES( ? , password( ? ), ? , ? )";
            PreparedStatement statement = con.prepareStatement(rawString);
            statement.setString(1,user_name);
            statement.setString(2,pass);
            statement.setString(3,tel);
            statement.setString(4,email);
            statement.executeUpdate();
            
            
            String rawString1 = "select user_id from user where user_name = ?";
            PreparedStatement statement1 = con.prepareStatement(rawString1);
            statement1.setString(1,user_name);
            ResultSet rs1 = statement1.executeQuery();
            

            String user_id = null;
            if (rs1.next()) {
                user_id = (String) rs1.getString("user_id");
            }

            
            String rawString2 = "select role_id from role where role_name = ?";
            PreparedStatement statement2 = con.prepareStatement(rawString2);
            statement2.setString(1,occupation);
            ResultSet rs2 = statement2.executeQuery();
            
            
            String role_id = null;
            if (rs2.next()) {
                role_id = (String) rs2.getString("role_id");
            }

            String rawString3 = "INSERT INTO user_role (user_id,role_id) VALUES ( ? , ? )";
            PreparedStatement statement3 = con.prepareStatement(rawString3);
            statement3.setString(1,user_id);
            statement3.setString(2,role_id);
            statement3.executeUpdate();
            
            String rawString4 = "INSERT INTO user_school (user_id,school_id) VALUES ( ? , ? )";
            PreparedStatement statement4 = con.prepareStatement(rawString4);
            statement4.setString(1,user_id);
            statement4.setString(2,school_id);
            statement4.executeUpdate();
            
            con.commit();
            success = true;

        } catch (SQLException ex) {
            if (con != null) {
                con.rollback();
            }
        }finally{
            if (con != null) {
                con.setAutoCommit(true);
            }
        }

        

        return success;
    }
}
