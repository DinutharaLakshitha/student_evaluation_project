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
    String NIC;
    String first_name,last_name,initials;
    String occupation;
    String gender;
    String tel_num;
    
    public Parent(String NIC, String first_name, String last_name, String initials, String occupation, String gender, String tel_num){
        this.NIC=NIC;
        this.first_name=first_name;
        this.last_name=last_name;
        this.initials=initials;
        this.occupation=occupation;
        this.tel_num=tel_num;
        
    }

    

}
