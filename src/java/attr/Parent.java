/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attr;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import utill.DbConnector;

/**
 *
 * @author ANTIROOKIE
 */
public class Parent {
    public  void  StoreData(String NIC,String first_name,String last_name,String initials,String occupation,String gender,String tel_num ) throws IOException, SQLException{ 
        DbConnector dbConnection= new DbConnector();
        Connection connection=dbConnection.getCon();
        
        Statement stm = connection.createStatement();
        stm.executeUpdate("INSERT INTO parent (NIC, first_name, last_name, initials, occupation, gender, tel_num) VALUE ('"+NIC+"', '"+first_name+"', '"+last_name+"', '"+initials+"', '"+occupation+"', '"+gender+"', '"+tel_num+"')");
    }

    public void StoreData(String nic, String fName, String lName, String init, String occupation, String telephone, String gender, String lName0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
