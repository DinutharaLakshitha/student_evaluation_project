/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attr;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import utill.DbConnector;

/**
 *
 * @author ANTIROOKIE
 */
public class Parent {

    public void StoreData(String NIC, String first_name, String last_name, String initials, String occupation, String gender, String tel_num) throws IOException, SQLException {
        DbConnector dbConnection = new DbConnector();
        Connection con = dbConnection.getCon();

        String rawString = "INSERT INTO parent (NIC, first_name, last_name, initials, occupation, gender, tel_num) VALUE (?,?,?,?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(rawString);
        statement.setString(1, NIC);
        statement.setString(2, first_name);
        statement.setString(3, last_name);
        statement.setString(4, initials);
        statement.setString(5, occupation);
        statement.setString(6, gender);
        statement.setString(7, tel_num);
        statement.executeUpdate();

    }

    public void StoreData(String nic, String fName, String lName, String init, String occupation, String telephone, String gender, String lName0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
