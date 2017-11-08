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
import java.util.Date;
import utill.DbConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            Statement stmt;

            stmt = con.createStatement();
            //rs = stmt.executeQuery("select user_name,password,occupation from interviewer where user_name = '"+uname+"' and password = '"+password+"'");
            rs = stmt.executeQuery("select user_name,pass,role_name from user join ((select user_id,role_name from user_role join role on user_role.role_id=role.role_id) as r) using (user_id) where user_name='" + uname + "' and pass='" + password + "'");

        } catch (SQLException ex) {
        }

        return rs;
    }

    public ResultSet getDetails(String uname) throws IOException {
        ResultSet rs = null;

        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();
            Statement stmt;

            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from user where user_name = '" + uname + "'");

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

            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE user SET pass = '" + new_password + "' WHERE user_name='" + user_name + "'");

            success = true;

        } catch (SQLException ex) {
        }

        return success;
    }

    public boolean registerUser(String user_name, String occupation, String tel, String pass) throws IOException {

        boolean success = false;
        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();

            Statement stmt1 = con.createStatement();
            stmt1.executeUpdate("INSERT INTO user (user_name,pass,telephone) VALUES ('" + user_name + "', password('" + pass + "'), '" + tel + "')");

            Statement stmt2 = con.createStatement();
            ResultSet rs1 = stmt2.executeQuery("select user_id from user where user_name = '" + user_name + "'");

            String user_id = null;
            if (rs1.next()) {
                user_id = (String) rs1.getString("user_id");
            }

            Statement stmt3 = con.createStatement();
            ResultSet rs2 = stmt3.executeQuery("select role_id from role where role_name = '" + occupation + "'");
            String role_id = null;
            if (rs2.next()) {
                role_id = (String) rs2.getString("role_id");
            }

            Statement stmt4 = con.createStatement();
            stmt4.executeUpdate("INSERT INTO user_role (user_id,role_id) VALUES ('" + user_id + "', '" + role_id + "')");

            success = true;

        } catch (SQLException ex) {

        }

        return success;
    }

    public boolean deleteUser(String user_name) throws IOException {

        boolean success = false;
        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();

            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from user where user_name='" + user_name + "'");

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
            Statement stmt;

            stmt = con.createStatement();
            rs = stmt.executeQuery("select password('" + password + "') as pass");

            if (rs.next()) {
                encrypted_password = (String) rs.getString("pass");
            }

        } catch (SQLException ex) {
        }
        return encrypted_password;
    }

    public String putMarks(String u_id, String app_id, int mark) throws IOException, ParseException {

        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();
            Statement stmt;

            Date date = new Date();
            int dd = date.getDate();
            int mm = date.getMonth();
            int yy = date.getYear() + 1990;
            String dt = yy + "-" + mm + "-" + dd;

            stmt = con.createStatement();
            //rs = stmt.executeQuery("select * from interview");
            stmt.executeUpdate("insert into interview values('" + u_id + "','" + app_id + "','" + mark + "','" + dt + "')");

        } catch (SQLException ex) {
            return "error";
        }
        return "success";
    }

}
