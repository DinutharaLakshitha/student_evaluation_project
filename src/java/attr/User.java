/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attr;

/**
 *
 * @author rajitha
 */
import java.io.IOException;
import utill.DbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

    private String user_name = null;
    private String ocupation = null;
    private String password = null;
    private String telephone = null;
    private String email = null;

    public ResultSet Login(String uname, String password) throws IOException {
        ResultSet rs = null;

        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();

            String rawString = "select user_name,pass,role_name from user join ((select user_id,role_name from user_role join role on user_role.role_id=role.role_id) as r) using (user_id) where user_name=? and pass=?";
            PreparedStatement statement = con.prepareStatement(rawString);
            statement.setString(1, uname);
            statement.setString(2, password);
            rs = statement.executeQuery();

        } catch (SQLException ex) {
        }

        return rs;
    }

    public ResultSet getDetails(String uname) throws IOException {
        ResultSet rs = null;

        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();

            String rawString = "select * from user where user_name = ?";
            PreparedStatement statement = con.prepareStatement(rawString);
            statement.setString(1, uname);
            rs = statement.executeQuery();

        } catch (SQLException ex) {
        }

        return rs;
    }

    public boolean changeUserPassword(String user_name, String new_password) throws IOException {
        boolean success = false;
        //UPDATE user SET `pass = '*A4B6157319038724E3560894F7F932C8886EBFCF' WHERE `interviewer`.`user_id` = 3;
        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();

            String rawString = "UPDATE user SET pass = ? WHERE user_name = ?";
            PreparedStatement statement = con.prepareStatement(rawString);
            statement.setString(1,new_password);
            statement.setString(2,user_name);
            statement.executeUpdate();

            success = true;

        } catch (SQLException ex) {
        }

        return success;
    }

    public boolean registerUser(String user_name, String occupation, String tel, String pass, String email) throws IOException, SQLException {

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

    public boolean deleteUser(String user_name) throws IOException {

        boolean success = false;
        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();

            String rawString = "delete from user where user_name= ?";
            PreparedStatement statement = con.prepareStatement(rawString);
            statement.setString(1,user_name);
            statement.executeUpdate();
            
            success = true;

        } catch (SQLException ex) {
        }

        return success;
    }

    public String returnEncryptedPassword(String password) throws IOException {
        ResultSet rs = null;
        String encrypted_password = null;

        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();
            
            String rawString = "select password( ? ) as pass";
            PreparedStatement statement = con.prepareStatement(rawString);
            statement.setString(1,password);
            rs = statement.executeQuery();
            
            if (rs.next()) {
                encrypted_password = (String) rs.getString("pass");
            }

        } catch (SQLException ex) {
        }
        return encrypted_password;
    }

//
//    public String putMarks(String u_id, String appid, int mark) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
