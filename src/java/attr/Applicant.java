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
    String f_name,l_name,initial;
    String h_num,street_name,city_name,grama,district;
    String dob;
    String gender;
    String religeon;
                         

    public Applicant(String f_name, String l_name, String initial, String h_num, String street_name, String city_name, String grama, String district,String dob, String gender, String religeon) {
        this.f_name=f_name;
        this.l_name=l_name;
        this.initial=initial;
        this.h_num=h_num;
        this.street_name=street_name;
        this.city_name=city_name;
        this.grama=grama;
        this.district=district;
        this.dob=dob;
        this.gender=gender;
        this.religeon=religeon;
        
        
        
    }
    

    
}
