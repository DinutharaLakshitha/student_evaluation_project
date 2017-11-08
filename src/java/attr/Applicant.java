/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attr;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static java.awt.Event.INSERT;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.JDBCType;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
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
public class Applicant {
    
    public boolean register(String f_name, String l_name, String initial, String gender0, String dob, String h_num, String street_name, String city_name, String district, String grama, String gender, String religeon) throws IOException, SQLException{
        ResultSet rs = null;
        boolean success=false;
        try {
            DbConnector db = new DbConnector();
            Connection conn =db.getCon();
             Statement stmt;
          
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO applicant (`first_name`, `last_name`, `initials`, `dob`, `gender`, `religion`, `home_number`, `street_name`, `city`, `district`, `grama_niladari_div`) VALUES ('"+f_name+"', '"+l_name+"', '"+initial+"', '"+dob+"', '"+gender0+"', '"+religeon+"', '"+h_num+"', '"+street_name+"', '"+city_name+"', '"+district+"', '"+grama+"')");
            /*stmt.executeUpdate("INSERT INTO applicant (`dob`) VALUES ('"+dob+"')");*/
            success=true;
         
            
            
        
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            
            
        }
        
        return success;
    
}


    
}
