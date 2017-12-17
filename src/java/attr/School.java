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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utill.DbConnector;
import java.util.*;
/**
 *
 * @author Dinuthara
 */
public class School {

    public boolean register(String name, String division, String district, String provision, String count) throws IOException, SQLException {
        ResultSet rs = null;
        boolean success = false;
        try {
            DbConnector db = new DbConnector();
            Connection conn = db.getCon();

            String rawString = "INSERT INTO school (`name`, `division`, `district`, `provision`, `eligible_count`) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(rawString);
            statement.setString(1, name);
            statement.setString(2, division);
            statement.setString(3, district);
            statement.setString(4, provision);
            statement.setString(5, count);
            statement.executeUpdate();

            success = true;

        } catch (SQLException ex) {
            
        }
        return success;
    }
   
    public HashMap getSchoolDetails() throws IOException{
        HashMap hashmap=new HashMap();
        ResultSet rs = null;
        try {
            DbConnector db = new DbConnector();
            Connection conn = db.getCon();

            String rawString = "select school_id,name from school";
            PreparedStatement statement = conn.prepareStatement(rawString);
            rs = statement.executeQuery();
            while (rs.next()){
                String key = (String) rs.getString("school_id");
                String value = (String) rs.getString("name");
                hashmap.put(key, value);
            }
        } catch (SQLException ex) {
            
        }
        return hashmap;
    }
}
