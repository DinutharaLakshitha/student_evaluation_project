<%-- 
    Document   : addSchool
    Created on : Nov 8, 2017, 9:28:39 PM
    Author     : Dinuthara
--%>

<%@page import="java.util.ArrayList"%>
<%
    String occupation=null;
    try{
        
        if(session.getAttribute("uname")==null){
            response.sendRedirect("index.jsp");
        }
        else{
            occupation=(String)session.getAttribute("occupation");
            if (!occupation.equals("dataEntry")) {
                response.sendRedirect("index.jsp");
            }
        }
    }catch(Exception e){
    }
    
    
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<title>Add School</title>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style_index.css">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {font-family: "Lato", sans-serif}
.mySlides {display: none}
</style>
<body>

<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card">
    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="home.jsp" class="w3-bar-item w3-button w3-padding-large">HOME</a>
    <a href="ViewProfile" class="w3-bar-item w3-button w3-padding-large w3-hide-small">VIEW PROFILE</a>
    <a href="changePassword.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">CHANGE PASSWORD</a>
    <% if (occupation.equals("admin")){%>
          <a href="registerUser.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">ADD USER</a>
    <%}%>
    <% if (occupation.equals("dataEntry")){%>
          <a href="addApplicant.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">ADD APPLICANT</a>
          <a href="addSchool.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small w3-orange">ADD SCHOOL</a>
    <%}%>
    <% if (occupation.equals("interviewer")){%>
          <a href="interviewStudent.jsp" class="w3-bar-item w3-button w3-padding-large">INTERVIEW STUDENT</a>
          <a href="forwardResults" class="w3-bar-item w3-button w3-padding-large">VIEW RESULTS</a>
  <%}%>
    <a href="Logout" class="w3-bar-item w3-button w3-padding-large w3-hide-small w3-right">LOG OUT</a>
    
      
  </div>
</div>

<!-- Navbar on small screens -->
<div id="navDemo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top" style="margin-top:46px">
  <a href="ViewProfile" class="w3-bar-item w3-button w3-padding-large">VIEW PROFILE</a>
  <a href="changePassword.jsp" class="w3-bar-item w3-button w3-padding-large">CHANGE PASSWORD</a>
  <% if (occupation.equals("admin")){%>
          <a href="registerUser.jsp" class="w3-bar-item w3-button w3-padding-large">ADD USER</a>
  <%}%>
  <% if (occupation.equals("dataEntry")){%>
          <a href="addApplicant.jsp" class="w3-bar-item w3-button w3-padding-large">ADD APPLICANT</a>
          <a href="addSchool.jsp" class="w3-bar-item w3-button w3-padding-large w3-orange">ADD SCHOOL</a>
  <%}%>
  <% if (occupation.equals("interviewer")){%>
          <a href="interviewStudent.jsp" class="w3-bar-item w3-button w3-padding-large">INTERVIEW STUDENT</a>
          <a href="forwardResults" class="w3-bar-item w3-button w3-padding-large">VIEW RESULTS</a>
  <%}%>
  <a href="Logout" class="w3-bar-item w3-button w3-padding-large">LOG OUT</a>
 
</div>

<!-- Page content -->
<div class="grad" style="max-width:2000px;margin-top:46px">

    
    <div class="login">
	<h1>Add School</h1>
    <form method="post" action="addSchool">
        <%try{
        
        ArrayList error =(ArrayList)session.getAttribute("Error");
        if(session.getAttribute("success")!=null){%><label class="label_ok"> Successfully Entered </label><br><br><%}
        session.removeAttribute("Error");
        session.setAttribute("success", null);
        for (int i = 0; i < error.size(); i++) {%>
        <label class="label_error" style="text-allign:center"><%out.println(error.get(i));%></label><br><br>
        <%}
        }catch(Exception e){
        }%>
        
        
        <input type="text"  name="txt_name" placeholder="School Name" required="required"  />
        <input type="text"  name="txt_division" placeholder="Division" required="required" />
        <input type="text"  name="txt_district" placeholder="District" required="required" />
        <input type="text"  name="txt_provision" placeholder="Provision" required="required"  />
        <input type="text"  name="txt_count" placeholder="Eligible Count" required="required"  />
    
              
            <button style="margin-top:20px;" type="submit" value="addSchool" class="btn btn-primary btn-block btn-large">Add School</button>
    </form>
</div>
  
  
<!-- End Page Content -->
</div>



<script>
// Automatic Slideshow - change image every 4 seconds
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 4000);    
}

// Used to toggle the menu on small screens when clicking on the menu button
function myFunction() {
    var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}

// When the user clicks anywhere outside of the modal, close it
var modal = document.getElementById('ticketModal');
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>

</body>
</html>

