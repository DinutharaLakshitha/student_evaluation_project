/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attr;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utill.DbConnector;

/**
 *
 * @author Dinuthara
 */
public class School {
    
        public boolean register(String name,String division,String district,String provision,String count) throws IOException, SQLException{
        ResultSet rs = null;
        boolean success=false;
        try {
            DbConnector db = new DbConnector();
            Connection conn =db.getCon();
             Statement stmt;
          
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO school (`name`, `division`, `district`, `provision`, `eligible_count`) VALUES ('"+name+"', '"+division+"', '"+district+"', '"+provision+"', '"+count+"')");
            /*stmt.executeUpdate("INSERT INTO applicant (`dob`) VALUES ('"+dob+"')");*/
            success=true;
         
            
            
        
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            
            
        }
        
        return success;
    
}
    
}
