/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attr;

import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

            String rawString = "select school_id from school where name = ?";
            PreparedStatement statement = con.prepareStatement(rawString);
            statement.setString(1, name);
            rs = statement.executeQuery();

        } catch (SQLException ex) {
            school_id = "error";
        }

        if (rs.next()) {
            school_id = rs.getString("school_id");
        } else {
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

            String rawString = "select distance from applicant_school where applicant_id = ? and school_id = ?";
            PreparedStatement statement = con.prepareStatement(rawString);
            statement.setString(1, applicant_id);
            statement.setString(2, school_id);
            rs = statement.executeQuery();

        } catch (SQLException ex) {

        }

        if (rs.next()) {
            distance = Float.parseFloat(rs.getString("distance"));
        }

        //criteria
        if (distance > 20) {
            mark = 5;
        } else if (distance > 15) {
            mark = 8;
        } else if (distance > 10) {
            mark = 10;
        } else {
            mark = 13;
        }

        return mark;
    }

    public ArrayList<String> getReferences(String applicantID) throws IOException, SQLException {
        ArrayList<String> refList = new ArrayList<>();
        ResultSet rs = null;
        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();

            String rawString = "select student_id from applicant_reference_student where applicant_id = ?";
            PreparedStatement statement = con.prepareStatement(rawString);
            statement.setString(1, applicantID);
            rs = statement.executeQuery();

        } catch (SQLException ex) {

        }

        while (rs.next()) {
            refList.add(rs.getString("student_id"));
        }
        return refList;
    }
    
    public String getSchoolName(String school_id) throws IOException, SQLException {
        String  name = "default";
        ResultSet rs = null;
        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();

            String rawString = "select name from school where school_id = ? ";
            PreparedStatement statement = con.prepareStatement(rawString);
            statement.setString(1, school_id);
            rs = statement.executeQuery();

        } catch (SQLException ex) {

        }

        if(rs.next()) {
            name = rs.getString(1);
        }
        return name;
    }
    
    public String getUserSchool(String user_name) throws IOException, SQLException {
        String  school_id = "default";
        ResultSet rs = null;
        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();

            String rawString = "select school_id from user_school natural join user where user_name = ? ";
            PreparedStatement statement = con.prepareStatement(rawString);
            statement.setString(1, user_name);
            rs = statement.executeQuery();

        } catch (SQLException ex) {

        }

        if(rs.next()) {
            school_id = rs.getString(1);
        }
        return school_id;
    }

    public ArrayList<String> getRefereeDetails(String student_ID) throws IOException, SQLException {
        ArrayList<String> details = new ArrayList<>();
        ResultSet rs = null;
        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();

            String rawString = "select distinct first_name, last_name,grade_5,ol,al,other from student, student_school where student.student_id = ? and student_school.student_id = ? and student.student_id = student_school.student_id";
            PreparedStatement statement = con.prepareStatement(rawString);
            statement.setString(1, student_ID);
            statement.setString(2, student_ID);
            rs = statement.executeQuery();

        } catch (SQLException ex) {
            details.add("error occured");
        }

        while (rs.next()) {
            for (int i = 1; i <= 6; i++) {
                details.add(rs.getString(i));
            }
        }
        return details;
    }

    public String putMarks(String u_id, String app_id, String school_id, float mark) throws IOException, ParseException {

        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();

            Date date = new Date();
            int dd = date.getDate();
            int mm = date.getMonth();
            int yy = date.getYear() + 1990;
            String dt = yy + "-" + mm + "-" + dd;

            String rawString = "insert into interview values(?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(rawString);
            statement.setString(1, u_id);
            statement.setString(2, app_id);
            statement.setString(3, school_id);
            String mk = mark + "";
            statement.setString(4, mk);
            statement.setString(5, dt);
            statement.executeUpdate();

        } catch (SQLException ex) {
            return "error";
        }
        return "success";
    }

    public ArrayList<ArrayList<String>> getResults(String school_id) throws IOException, SQLException {
        ArrayList<ArrayList<String>> resultSet = new ArrayList<>();
        ResultSet rs = null;
        try {
            DbConnector db = new DbConnector();
            Connection con = db.getCon();

            String rawString = "select applicant_id, first_name, last_name, initials, interview_marks from applicant natural join interview where school_id = ? order by interview_marks DESC";
            PreparedStatement statement = con.prepareStatement(rawString);
            statement.setString(1, school_id);
            rs = statement.executeQuery();

        } catch (SQLException ex) {
            
        }
        int rank = 1;
        while (rs.next()) {
            ArrayList<String> newRow = new ArrayList<String>();
            //[ID, full name, marks, rank]
            newRow.add(rs.getString(1));
            newRow.add((rs.getString(4) + " " + rs.getString(2) + " " + rs.getString(3)));
            newRow.add(rs.getString(5));
            newRow.add((rank + ""));
            rank++;
            resultSet.add(newRow);
        }
        return resultSet;
    }
}
