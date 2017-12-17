package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class viewResults_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');

    /*
    String occupation="none";
    try{
        
        if(session.getAttribute("uname")==null){
            response.sendRedirect("index.jsp");
        }
        else{
            occupation=(String)session.getAttribute("occupation");
        }
    }catch(Exception e){
    }
    */
    

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<title>View Profile</title>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"css/w3.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("<style>\n");
      out.write("body {font-family: \"Lato\", sans-serif}\n");
      out.write(".mySlides {display: none}\n");
      out.write("</style>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<!-- Navbar -->\n");
      out.write("<div class=\"w3-top\">\n");
      out.write("  <div class=\"w3-bar w3-black w3-card\">\n");
      out.write("    <a class=\"w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right\" href=\"javascript:void(0)\" onclick=\"myFunction()\" title=\"Toggle Navigation Menu\"><i class=\"fa fa-bars\"></i></a>\n");
      out.write("    <a href=\"home.jsp\" class=\"w3-bar-item w3-button w3-padding-large\">HOME</a>\n");
      out.write("    <a href=\"ViewProfile\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small w3-orange\">VIEW PROFILE</a>\n");
      out.write("    <a href=\"changePassword.jsp\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">CHANGE PASSWORD</a>\n");
      out.write("    ");
 if (occupation.equals("admin")){
      out.write("\n");
      out.write("          <a href=\"registerUser.jsp\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">ADD USER</a>\n");
      out.write("    ");
}
      out.write("\n");
      out.write("    ");
 if (occupation.equals("dataEntry")){
      out.write("\n");
      out.write("          <a href=\"addApplicant.jsp\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">ADD APPLICANT</a>\n");
      out.write("    ");
}
      out.write("\n");
      out.write("    ");
 if (occupation.equals("interviewer")){
      out.write("\n");
      out.write("          <a href=\"interviewStudent.jsp\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">INTERVIEW STUDENT</a>\n");
      out.write("    ");
}
      out.write("\n");
      out.write("    <a href=\"Logout\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small w3-right\">LOG OUT</a>\n");
      out.write("    \n");
      out.write("      \n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Navbar on small screens -->\n");
      out.write("<div id=\"navDemo\" class=\"w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top\" style=\"margin-top:46px\">\n");
      out.write("  <a href=\"ViewProfile\" class=\"w3-bar-item w3-button w3-padding-large w3-orange\">VIEW PROFILE</a>\n");
      out.write("  <a href=\"changePassword.jsp\" class=\"w3-bar-item w3-button w3-padding-large\">CHANGE PASSWORD</a>\n");
      out.write("  ");
 if (occupation.equals("admin")){
      out.write("\n");
      out.write("          <a href=\"registerUser.jsp\" class=\"w3-bar-item w3-button w3-padding-large\">ADD USER</a>\n");
      out.write("  ");
}
      out.write("\n");
      out.write("  ");
 if (occupation.equals("dataEntry")){
      out.write("\n");
      out.write("          <a href=\"addApplicant.jsp\" class=\"w3-bar-item w3-button w3-padding-large\">ADD APPLICANT</a>\n");
      out.write("  ");
}
      out.write("\n");
      out.write("  ");
 if (occupation.equals("interviewer")){
      out.write("\n");
      out.write("          <a href=\"interviewStudent.jsp\" class=\"w3-bar-item w3-button w3-padding-large\">INTERVIEW STUDENT</a>\n");
      out.write("  ");
}
      out.write("\n");
      out.write("  <a href=\"Logout\" class=\"w3-bar-item w3-button w3-padding-large\">LOG OUT</a>\n");
      out.write(" \n");
      out.write("</div>\n");
      out.write("  \n");
      out.write("  \n");
      out.write("<!-- Page content -->\n");
      out.write("<div class=\"w3-content\" style=\"max-width:2000px;margin-top:46px\">\n");
      out.write("    \n");
      out.write("        <h1>View Interview Result for \"school name\"</h1>\n");
      out.write("        <div align=\"center\">\n");
      out.write("        <table border=\"1\" cellpadding=\"5\">\n");
      out.write("            <caption><h2>List of users</h2></caption>\n");
      out.write("            <tr>\n");
      out.write("                <th>ID</th>\n");
      out.write("                <th>Name</th>\n");
      out.write("                <th>Email</th>\n");
      out.write("                <th>Profession</th>\n");
      out.write("            </tr>\n");
      out.write("            <c:forEach var=\"user\" items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listUsers.rows}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <tr>\n");
      out.write("                    <td><c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /></td>\n");
      out.write("                    <td><c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /></td>\n");
      out.write("                    <td><c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /></td>\n");
      out.write("                    <td><c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.profession}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /></td>\n");
      out.write("                </tr>\n");
      out.write("            </c:forEach>\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("  \n");
      out.write("<!-- End Page Content -->\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("// Automatic Slideshow - change image every 4 seconds\n");
      out.write("var myIndex = 0;\n");
      out.write("carousel();\n");
      out.write("\n");
      out.write("function carousel() {\n");
      out.write("    var i;\n");
      out.write("    var x = document.getElementsByClassName(\"mySlides\");\n");
      out.write("    for (i = 0; i < x.length; i++) {\n");
      out.write("       x[i].style.display = \"none\";  \n");
      out.write("    }\n");
      out.write("    myIndex++;\n");
      out.write("    if (myIndex > x.length) {myIndex = 1}    \n");
      out.write("    x[myIndex-1].style.display = \"block\";  \n");
      out.write("    setTimeout(carousel, 4000);    \n");
      out.write("}\n");
      out.write("\n");
      out.write("// Used to toggle the menu on small screens when clicking on the menu button\n");
      out.write("function myFunction() {\n");
      out.write("    var x = document.getElementById(\"navDemo\");\n");
      out.write("    if (x.className.indexOf(\"w3-show\") == -1) {\n");
      out.write("        x.className += \" w3-show\";\n");
      out.write("    } else { \n");
      out.write("        x.className = x.className.replace(\" w3-show\", \"\");\n");
      out.write("    }\n");
      out.write("}\n");
      out.write("\n");
      out.write("// When the user clicks anywhere outside of the modal, close it\n");
      out.write("var modal = document.getElementById('ticketModal');\n");
      out.write("window.onclick = function(event) {\n");
      out.write("  if (event.target == modal) {\n");
      out.write("    modal.style.display = \"none\";\n");
      out.write("  }\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
