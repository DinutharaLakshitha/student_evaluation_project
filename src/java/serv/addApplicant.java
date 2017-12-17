/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import attr.Applicant;
import attr.ParentChild;
import attr.Validation;
import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dinuthara
 */
@WebServlet(name = "addApplicant", urlPatterns = {"/addApplicant"})
public class addApplicant extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ArrayList<String> error;
            error = new ArrayList<>();
            ArrayList<String> applicantData;
            applicantData=new ArrayList<>();
            
            HttpSession session=request.getSession();
            session.setAttribute("Error", error);
            session.setAttribute("applicantData", applicantData);
            
            
            
         
            String f_name = request.getParameter("txt_fname");
            String initial = request.getParameter("txt_init");
            String l_name = request.getParameter("txt_lname");
       
            String h_num = request.getParameter("txt_home_num");
            String street_name = request.getParameter("txt_street_name");
            String city_name = request.getParameter("txt_city_name");
            String district = request.getParameter("txt_district");
            String grama = request.getParameter("txt_grama");
            
            
            String b_day = request.getParameter("date");
            String b_month = request.getParameter("month");
            
            
            
            String gender = request.getParameter("gender");
            String religeon = request.getParameter("religion");
            
            Validation valid = new Validation();
            
            if(valid.onlyLettersSpaces(f_name)== false){error.add("Invalid First Name");}
            if(valid.onlyLettersSpaces(l_name)== false){error.add("Invalid Last Name");}
            if(valid.onlyLettersSpaces(city_name)== false){error.add("Invalid City");}
            if(valid.onlyLettersSpaces(district)== false){error.add("Invalid District");}
            if(valid.onlyLettersSpaces(grama)== false){error.add("Invalid Grama Niladari Area");}
            if(valid.onlyInitials(initial)== false){error.add("Invalid Initials");}
            if(valid.onlyLettersSpacesdot(street_name)==false){error.add("Invalid Street Name");}
            if(valid.onlyLettersSpacesslash(h_num) == false){error.add("Invalid home number");}
            if(b_day.equals("NO")){error.add("Input a date");}
            if(b_month.equals("NO")){error.add("Input a month");}
            
            int year = Calendar.getInstance().get(Calendar.YEAR);
            
            if(b_month.equals("NO")){year-=4;}
            else{year-=5;}
            
            String Year = Integer.toString(year);
            
            String dob = Year+"-"+b_month+"-"+b_day;
            
            
            
            if(error.size()>0){
                response.sendRedirect("addApplicant.jsp");
            }
            else{ 
                //Applicant applicant = new Applicant();
            
                out.println("Object created");
                Applicant applicant=new Applicant(f_name, l_name, initial, h_num, street_name, city_name, grama, district, dob, gender, religeon);
                session.setAttribute("Applicant", applicant);
                
                
                
                
            
               // boolean a = applicant.register(f_name, l_name,initial, gender, dob, h_num, street_name, city_name,district,grama,gender,religeon);
              //  out.println(a);
                response.sendRedirect("addParent.jsp");
               
            }
            }
            
            
            
            
             
            
            
            
            
            
            
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(addApplicant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(addApplicant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
