<%
    try{
        if(session.getAttribute("uname")==null){
            response.sendRedirect("index.jsp");
        }
    }catch(Exception e){
    }
    
    String occupation=(String)session.getAttribute("occupation");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<title>Register User</title>
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
    <a href="viewProfile.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">VIEW PROFILE</a>
    <a href="changePassword.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">CHANGE PASSWORD</a>
    <% if (occupation.equals("admin")){%>
          <a href="registerUser.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small w3-orange">ADD USER</a>
    <%}%>
    <% if (occupation.equals("dataEntry")){%>
          <a href="addApplicant.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">ADD APPLICANT</a>
    <%}%>
    <% if (occupation.equals("interviewer")){%>
          <a href="interviewStudent.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">INTERVIEW STUDENT</a>
    <%}%>
    <a href="Logout" class="w3-bar-item w3-button w3-padding-large w3-hide-small w3-right">LOG OUT</a>
    
      
  </div>
</div>

<!-- Navbar on small screens -->
<div id="navDemo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top" style="margin-top:46px">
  <a href="viewProfile.jsp" class="w3-bar-item w3-button w3-padding-large">VIEW PROFILE</a>
  <a href="changePassword.jsp" class="w3-bar-item w3-button w3-padding-large">CHANGE PASSWORD</a>
  <% if (occupation.equals("admin")){%>
          <a href="registerUser.jsp" class="w3-bar-item w3-button w3-padding-large w3-orange">ADD USER</a>
  <%}%>
  <% if (occupation.equals("dataEntry")){%>
          <a href="addApplicant.jsp" class="w3-bar-item w3-button w3-padding-large">ADD APPLICANT</a>
  <%}%>
  <% if (occupation.equals("interviewer")){%>
          <a href="interviewStudent.jsp" class="w3-bar-item w3-button w3-padding-large">INTERVIEW STUDENT</a>
  <%}%>
  <a href="Logout" class="w3-bar-item w3-button w3-padding-large">LOG OUT</a>
 
</div>

<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">

    
<div class="login">
    <div class="w3-container w3-blue-gray w3-section w3-round-large w3-padding-large">
    <h1>Register User</h1>
    <form method="post" action="Login">
        <%try{

        String error =(String)session.getAttribute("error");
        if (error.equals("errorOccured")){
            session.removeAttribute("error");%>
            <label>Invalid Username or Password</label>
        <%}
        }catch(Exception e){
        }%>

        <input style="margin-top:20px;" type="text" name="uname" placeholder="Enter Username" required="required" autofocus="true"/>
        <input style="margin-top:10px;" type="password" name="pass" placeholder="Enter Password" required="required" />
        <input style="margin-top:10px;" type="password" name="confirm_pass" placeholder="Confirm Password" required="required" />
        <button style="margin-top:10px;" type="submit" value="Login" class="btn btn-primary btn-block btn-large">Register User</button>
    </form>
    </div>
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


