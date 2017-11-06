/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attr;
import java.io.IOException;
import utill.DbConnector;
import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class User {
    
    public ResultSet Login(String uname , String pass) throws IOException{
        ResultSet rs = null;
        
        try {
            DbConnector db = new DbConnector();
            Connection con =db.getCon();
            Statement stmt;
          
            stmt = con.createStatement();
            rs = stmt.executeQuery("select user_name,password,occupation from interviewer where user_name = '"+uname+"' and password = '"+pass+"'");
            
            
        
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            
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
            rs = stmt.executeQuery("select * from users where user_name = '"+uname+"'");
            
            
        
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return rs;
    }
    
}
