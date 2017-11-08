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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

public class User {
    private String user_name=null;
    private String ocupation=null;
    private String password=null;
    private String telephone=null;
    private String email=null;
    
   
  
    
    public ResultSet Login(String uname , String password) throws IOException{
        ResultSet rs = null;
        
        try {
            DbConnector db = new DbConnector();
            Connection con =db.getCon();
            Statement stmt;
          
            stmt = con.createStatement();
            //rs = stmt.executeQuery("select user_name,password,occupation from interviewer where user_name = '"+uname+"' and password = '"+password+"'");
            rs = stmt.executeQuery("select user_name,pass,role_name from user join ((select user_id,role_name from user_role join role on user_role.role_id=role.role_id) as r) using (user_id) where user_name='"+uname+"' and pass='"+password+"'");
//            select * from user join ((select user_id,role_name from user_role join role on user_role.role_id=role.role_id) as r) using (user_id) where user_name='rajitha';
            
        } catch (SQLException ex) {  
        }
        
        return rs;
    }
    
    public ResultSet getDetails(String uname) throws IOException{
        ResultSet rs = null;
        
        try {
            DbConnector db = new DbConnector();
            Connection con =db.getCon();
            Statement stmt;
          
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from interviewer where user_name = '"+uname+"'");
            
            
        
        } catch (SQLException ex) {   
        }
        
        return rs;
    }
    
    public boolean registerUser(String user_name,String occupation,String tel,String pass) throws IOException{
        ResultSet rs = null;
        boolean success=false;
        try {
            DbConnector db = new DbConnector();
            Connection con =db.getCon();
            Statement stmt;
          
            stmt = con.createStatement();
            
            stmt.executeUpdate("INSERT INTO interviewer (user_name,password,telephone,occupation) VALUES ('"+user_name+"', password('"+pass+"'), '"+tel+"', '"+occupation+"')");
            success=true;
            
        
        } catch (SQLException ex) {  
        }
        
        return success;
    }
    
    public String returnEncryptedPassword(String password) throws IOException{
        ResultSet rs = null;
        String encrypted_password=null;
        
        try {
            DbConnector db = new DbConnector();
            Connection con =db.getCon();
            Statement stmt;
          
            stmt = con.createStatement();
            rs = stmt.executeQuery("select password('"+password+"') as pass");
            
            if(rs.next()){
                encrypted_password = (String)rs.getString("pass");
            }
 
        } catch (SQLException ex) {  
        }
        return encrypted_password;
    }
    public String putMarks() throws IOException{
       ResultSet rs = null;
        
        try {
            DbConnector db = new DbConnector();
            Connection con =db.getCon();
            Statement stmt;
          
            stmt = con.createStatement();
            //rs = stmt.executeQuery("select * from interview");
            stmt.executeUpdate("insert into interview values('1','1','12','2017-11-18')");
            
        
        } catch (SQLException ex) {   
            return ex.toString();
        }
        
        
     return "success";   
    }
    
}
