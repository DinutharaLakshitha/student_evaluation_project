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

    public boolean register(String f_name, String l_name, String initial, String gender0, String dob, String h_num, String street_name, String city_name, String district, String grama, String gender, String religeon) throws IOException, SQLException {
        ResultSet rs = null;
        boolean success = false;
        try {
            DbConnector db = new DbConnector();
            Connection conn = db.getCon();

            String rawString = "INSERT INTO applicant (`first_name`, `last_name`, `initials`, `dob`, `gender`, `religion`, `home_number`, `street_name`,`city`, `district`, `grama_niladari_div`) VALUES (?, ?, ?,?, ?,?,?, ?,?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(rawString);
            statement.setString(1, f_name);
            statement.setString(2, l_name);
            statement.setString(3, initial);
            statement.setString(4, dob);
            statement.setString(5, gender0);
            statement.setString(6, religeon);
            statement.setString(7, h_num);
            statement.setString(8, street_name);
            statement.setString(9, city_name);
            statement.setString(10, district);
            statement.setString(11, grama);
            statement.executeUpdate();

            success = true;

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);

        }

        return success;

    }

}
