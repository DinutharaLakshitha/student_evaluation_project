/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import attr.User;
import attr.Validation;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * @author rajitha
 */
@WebServlet(name = "ChangePassword", urlPatterns = {"/ChangePassword"})
public class ChangePassword extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//            UPDATE `interviewer` SET `password` = '*A4B6157319038724E3560894F7F932C8886EBFCF' WHERE `interviewer`.`user_id` = 3;
            HttpSession session=request.getSession(); 
            ArrayList<String> error;
            error = new ArrayList<>();
            session.setAttribute("Error", error);


            if(session.getAttribute("uname")==null){
                response.sendRedirect("index.jsp");
            }else{
                
                String user_name=(String) session.getAttribute("uname");
                String current_password = request.getParameter("current_pass");             
                String new_password = request.getParameter("new_pass");
                String confirm_password = request.getParameter("confirm_pass");
                

                if (current_password==null){
                    response.sendRedirect("changePassword.jsp");
                }else{
//                    error.add("Username already in use.");
                    User u =new User();
                        
                    String encrypted_password=u.returnEncryptedPassword(current_password);
                    String encrypted_new_password=u.returnEncryptedPassword(new_password);
                    
                    ResultSet rs = u.getDetails(user_name);
                        
                    if(rs.next()){
                        String old_password=(String) rs.getString("pass");
                        if (!old_password.equals(encrypted_password)){
                            error.add("Wrong password.Try again.");
                        }
                    }
                    Validation validation=new Validation();
            
                    if (validation.validatePasswordStrong(new_password)){
                        if (!new_password.equals(confirm_password)){
                            error.add("New password not match");
                        }
                    }else{
                        error.add("New password should have Capital letters, signs, numbers.");
                    }
                    
                    
                    if (error.size()>0){
                        response.sendRedirect("changePassword.jsp");
                    }else{
                        boolean success=u.changeUserPassword(user_name, encrypted_new_password);
                        if (success){
                            session.setAttribute("success","Password successfully changed.");
                        }else{
                            error.add("Erorr while changing password.");
                        }
                        response.sendRedirect("changePassword.jsp");
                    }
//                        
                }

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
            Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
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
