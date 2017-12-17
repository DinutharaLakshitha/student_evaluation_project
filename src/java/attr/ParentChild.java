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
import utill.DbConnector;

/**
 *
 * @author ANTIROOKIE
 */
public class ParentChild {
    
    public boolean storeData(Parent parent, Applicant applicant) throws IOException, SQLException{
        boolean successA = false;
        boolean successP =false;
        boolean successB=false;
        boolean successR=false;
        DbConnector db;
        Connection con = null;
        try {
            db = new DbConnector();
            con = db.getCon();
            con.setAutoCommit(false);
            
            String rawString1 = "INSERT INTO applicant (`first_name`, `last_name`, `initials`, `dob`, `gender`, `religion`, `home_number`, `street_name`,`city`, `district`, `grama_niladari_div`) VALUES (?, ?, ?,?, ?,?,?, ?,?, ?, ?)";
            PreparedStatement statement1 = con.prepareStatement(rawString1);
            statement1.setString(1, applicant.f_name);
            statement1.setString(2, applicant.l_name);
            statement1.setString(3, applicant.initial);
            statement1.setString(4, applicant.dob);
            statement1.setString(5, applicant.gender);
            statement1.setString(6, applicant.religeon);
            statement1.setString(7, applicant.h_num);
            statement1.setString(8, applicant.street_name);
            statement1.setString(9, applicant.city_name);
            statement1.setString(10, applicant.district);
            statement1.setString(11, applicant.grama);
            statement1.executeUpdate();
            
            

            successA = true;
            
            String rawId= "SELECT applicant_id from applicant WHERE first_name= ? AND last_name= ? AND initials= ? AND dob= ? AND gender= ? AND religion= ? AND home_number= ? AND street_name= ? AND city= ? AND district= ? AND grama_niladari_div= ?";
            PreparedStatement stm= con.prepareStatement(rawId);
            stm.setString(1, applicant.f_name);
            stm.setString(2, applicant.l_name);
            stm.setString(3, applicant.initial);
            stm.setString(4, applicant.dob);
            stm.setString(5, applicant.gender);
            stm.setString(6, applicant.religeon);
            stm.setString(7, applicant.h_num);
            stm.setString(8, applicant.street_name);
            stm.setString(9, applicant.city_name);
            stm.setString(10, applicant.district);
            stm.setString(11, applicant.grama);
            
            ResultSet resultset =stm.executeQuery(rawId);
                                        
                 int a=resultset.getInt("applicant_id");
                successB=true;
           
                 
           
            
            
            
            String rawString2 = "INSERT INTO parent (NIC, first_name, last_name, initials, occupation, gender, tel_num) VALUE (?,?,?,?,?,?,?)";
            PreparedStatement statement2 = con.prepareStatement(rawString2);
            statement2.setString(1, parent.NIC);
            statement2.setString(2, parent.first_name);
            statement2.setString(3, parent.last_name);
            statement2.setString(4, parent.initials);
            statement2.setString(5, parent.occupation);
            statement2.setString(6, parent.gender);
            statement2.setString(7, parent.tel_num);
            statement2.executeUpdate();
        
            successP=true;
            
            String rawString3= "INSERT INTO applicant_parent (applicant_id,NIC) VALUE (?, ?)";
            PreparedStatement statement3 =con.prepareStatement(rawString3);
            statement3.setInt(1,a);
            statement3.setString(2,parent.NIC);
            statement3.executeUpdate();
            
            successR=true;
                    
            con.setAutoCommit(true);
            
            
            
        }
        catch(SQLException e){
            successA=false;
            successP=false;
            if (con != null) {
                con.rollback();
            }   
        }
        finally{
            if (con != null) {
                con.setAutoCommit(true);
        }
        
    }
        return (true);
        
        
    }
    
    /*public String getdata(Applicant applicant) throws SQLException, IOException {
        Connection c =new DbConnector().getCon();
        String rawId= "SELECT applicant_id from applicant WHERE first_name= '"+applicant.f_name+"' AND last_name='"+applicant.l_name+"' AND initials='"+applicant.initial+"' AND dob='"+applicant.dob+"' AND gender='"+applicant.gender+"' AND religion='"+applicant.religeon+"' AND home_number='"+applicant.h_num+"' AND street_name='"+applicant.street_name+"' AND city='"+applicant.city_name+"' district='"+applicant.district+"' AND grama_niladari_div='"+applicant.grama+"'";
            Statement stm= c.createStatement();
            ResultSet resultset =stm.executeQuery(rawId);
            System.out.println("rawId");
                            
                 int a=resultset.getInt("applicant_id");
                return rawId;*/
    }
    
}
