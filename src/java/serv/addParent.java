/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import attr.Applicant;
import attr.Parent;
import attr.ParentChild;
import attr.Validation;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
 * @author ANTIROOKIE
 */
@WebServlet(name = "addParent", urlPatterns = {"/addParent"})
public class addParent extends HttpServlet {

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
        out.print("hii");
        ArrayList<String> error;
        error = new ArrayList<>();
        HttpSession session=request.getSession();
        session.setAttribute("Error", error);
        
        Applicant applicant=(Applicant) session.getAttribute("Applicant");
      
        try (PrintWriter out = response.getWriter()) {
            String fName =request.getParameter("txt_fname");
            String lName =request.getParameter("txt_lname");
            String init =request.getParameter("txt_init");
            String nic =request.getParameter("txt_NIC");
            String gender=request.getParameter("txt_gender");
            String occupation =request.getParameter("txt_occupation");
            String telephone =request.getParameter("txt_telephone");
                       
             Validation valid=new Validation();
            out.print("hii 2");
           if (!valid.onlyLetters(fName)){error.add("Invalid first name");}
           out.print("hii 3");
           if (!valid.onlyLetters(lName)){error.add("Invalid Last name");}
           out.print("hii 4");
           if (!valid.onlyInitials(init)){error.add("Invalid Initials Use capitals");}
           out.print("hii 5");
           if (!valid.NICValid(nic)){error.add("Invalid NIC Number");}
           out.print("hii 6");
           if (valid.GenderValid(gender)){error.add("Invalid Gender");}
           out.print("hii 7");
           if (!valid.onlyLetters(occupation)){error.add("Invalid Occcupation");}
           out.print("hii 8");
           if (!valid.TelValid(telephone)){error.add("Invalid Telephone Number");}
           out.print("hii 9");
           
            if(error.size()>0){
                response.sendRedirect("addParent.jsp");
            }
            else{ 
                 out.print("hii 10");
                Parent parent=new Parent( nic,  fName,  lName,  init,  occupation,  gender,  telephone);
                out.print("hii 11");
                ParentChild parentChild =new ParentChild();
                parentChild.storeData(parent, applicant);
                //response.sendRedirect("home.jsp");
                
                
             
               // parent.StoreData(nic, fName, lName, init, occupation, gender,telephone);
                out.print("a");
                //response.sendRedirect("home.jsp");
                
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
            Logger.getLogger(addParent.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(addParent.class.getName()).log(Level.SEVERE, null, ex);
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
