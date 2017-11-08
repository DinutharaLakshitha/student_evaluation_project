/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import attr.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

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
            
            HttpSession session=request.getSession(); 

            if(session.getAttribute("uname")==null){
                response.sendRedirect("index.jsp");
            }else{

                String name = request.getParameter("new_uname");             
                String occupation = request.getParameter("occupation");
                String tel = request.getParameter("tel");
                String pass = request.getParameter("pass");
                String confirm_pass = request.getParameter("confirm_pass");


                if (occupation.equals("null")){
                    session.setAttribute("new_uname",name);
                    //session.setAttribute("new_occupation",occupation);
                    session.setAttribute("tel",tel);
                    session.setAttribute("error","Please select occupation.");
                    response.sendRedirect("registerUser.jsp");
                }else{

                    if (pass.equals(confirm_pass)){
                        User u =new User();

                        /*out.println(name);
                        out.println(occupation);
                        out.println(tel);
                        out.println(pass);
                        out.println(confirm_pass);*/

                        ResultSet rs = u.getDetails(name);
                        
                        if(rs.next()){
                            session.setAttribute("new_uname",name);
                            //session.setAttribute("new_occupation",occupation);
                            session.setAttribute("tel",tel);
                            session.setAttribute("error","Username already in use.");
                            response.sendRedirect("registerUser.jsp");
                        }else{

                            boolean success= u.registerUser(name, occupation, tel, pass);

                            out.println(success);
                            if (success){
                                session.setAttribute("success","User "+name+" successfully added.");
                            }else{
                                u.deleteUser(name);
                                session.setAttribute("error","Error occured while adding user.");
                            }
                            response.sendRedirect("registerUser.jsp");
                        }
                    }
                    else{
                        session.setAttribute("new_uname",name);
                        //session.setAttribute("new_occupation",occupation);
                        session.setAttribute("tel",tel);
                        session.setAttribute("error","Password not match");
                        response.sendRedirect("registerUser.jsp");
                    }
                }
//                }

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
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
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
