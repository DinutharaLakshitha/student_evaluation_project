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
import java.text.ParseException;
import java.util.Date;
import utill.DbConnector;

/**
 *
 * @author chathuranga
 */
public class Interview {

    public String getSchoolId(String name) throws IOException, SQLException {
        ResultSet rs = null;
        String school_id = "start";
        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();
            Statement stmt;

            stmt = con.createStatement();
            rs = stmt.executeQuery("select school_id from school where name = '" + name + "'");
        } catch (SQLException ex) {
            school_id = "error";
        }

        if (rs.next()) {
            school_id = rs.getString("school_id");
        }
        else{
            school_id = "no results";
        }
        return school_id;
    }
    
    public float getDistanceMarks(String applicant_id, String school_id) throws IOException, SQLException {
        ResultSet rs = null;
        float mark = 0;
        float distance = 0;
        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();
            Statement stmt;

            stmt = con.createStatement();
            rs = stmt.executeQuery("select distance from applicant_school where applicant_id = '" + applicant_id + "' and school_id = '"+school_id+"'");
        } catch (SQLException ex) {
            
        }

        if (rs.next()) {
            distance = Float.parseFloat(rs.getString("distance"));
        }
        
        //criteria
        if(distance>20){
            mark = 5;
        }
        else if(distance>15){
            mark = 8;
        }
        else if(distance>10){
            mark = 10;
        }
        else{
            mark = 13;
        }
        
        return mark;
    }
public String putMarks(String u_id, String app_id, String school_id, float mark) throws IOException, ParseException {

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
            stmt.executeUpdate("insert into interview values('" + u_id + "','" + app_id + "','" + school_id + "','" + mark + "','" + dt + "')");

        } catch (SQLException ex) {
            return "error";
        }
        return "success";
    }
}
