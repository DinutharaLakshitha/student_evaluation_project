/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import attr.Interview;
import attr.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utill.DbConnector;

/**
 *
 * @author chathuranga
 */
@WebServlet(name = "putMarks", urlPatterns = {"/putMarks"})
public class putMarks extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            
            int mark1 = Integer.parseInt(request.getParameter("mark1"));
            int mark2 = Integer.parseInt(request.getParameter("mark2"));
            float mark3 = (float)(session.getAttribute("dist_mark"));
            
            float mark = mark1 + mark2 + mark3;
            
            String appid = (String)session.getAttribute("applicant_id");
            String u_name = (String)session.getAttribute("uname");
            String school_id = (String)session.getAttribute("school_id");
            String u_id = "";
            
            User uu = new User();
            ResultSet rs = uu.getDetails(u_name);
            if(rs.next()){
                u_id = rs.getString("user_id");
            }

            Interview obj = new Interview();
            
            String attempt = obj.putMarks(u_id, appid,school_id, mark);
            out.println("<p>");
            out.println(attempt);
            out.println("</p>");
            session.setAttribute("success", true);
            
            response.sendRedirect("interviewStudent.jsp");
            /*
             boolean attempt = uu.putMarks();
             if(attempt){
             out.println("<p>");
             out.println("done");
             out.println("</p>");
             }
             else{
             out.println("<p>");
             out.println("error");
             out.println("</p>");
             }
             */
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
            Logger.getLogger(putMarks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(putMarks.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(putMarks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(putMarks.class.getName()).log(Level.SEVERE, null, ex);
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
