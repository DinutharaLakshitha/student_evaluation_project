<%
    String occupation="none";
    try{
        
        if(session.getAttribute("uname")==null){
            response.sendRedirect("index.jsp");
        }
        else{
            occupation=(String)session.getAttribute("occupation");
            if (!occupation.equals("dataEntry")){
                response.sendRedirect("index.jsp");
            }
        }
    }catch(Exception e){
    }
    
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<title>Add Applicant</title>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style_addStudent.css">
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
<div class="grad" style="max-width:2000px;margin-top:46px">

    
    <div class="login">
	<h1>Add Applicant</h1>
    <form method="post" action="addapplicant">
        <%try{
        
        String error =(String)session.getAttribute("error");
        if (error.equals("errorOccured")){
            session.removeAttribute("error");%>
            <label>Invalid Username or Password</label>
        <%}
        }catch(Exception e){
        }%>
        
        <h4 style="color:blue;">ID</h4>
        <input style="margin-top:10px;" type="text" name="txt_idno" placeholder="Application Number" />
        <h4 style="color:blue;" >NAME</h4>
        <input style="margin-top:10px;" type="text"  name="txt_fname" placeholder="First Name" />
        <input style="margin-top:10px;" type="text"  name="txt_mname" placeholder="Middle Name Initial in Capital" />
        <input style="margin-top:10px;" type="text"  name="txt_lname" placeholder="Last Name" />
        <h4 style="color:blue;" >ADDRESS</h4>
        <input style="margin-top:10px;" type="text"  name="txt_home_num" placeholder="Home Number"  />
        <input style="margin-top:10px;" type="text"  name="txt_street_name" placeholder="Street Name"  />
        <input style="margin-top:10px;" type="text"  name="txt_city_name" placeholder="City" />
        <h4 style="color:blue;" >Contact</h4>
        <input type="text" name="txt_phone" placeholder="Phone Number" />
        <h4 style="color:blue;" >Date of Birth</h4>
              
                <select class="select" style="margin-top:10px;" name="date">
                  <option value="NO">Date</option>
                  <option value="0">0</option>
                  <option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option>
                  <option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option>
                  <option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option>
                  <option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option>
                  <option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option>
                  <option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option>
                  <option value="31">31</option>



                </select>
        
        
                <select class="select" style="margin-top:10px;" name="month">
                  <option value="NO">Month</option>
                  <option value="1">jan</option>
                  <option value="2">feb</option>
                  <option value="3">mar</option>
                  <option value="4">aprl</option>
                  <option value="5">may</option>
                  <option value="6">june</option>
                  <option value="7">july</option>
                  <option value="8">aug</option>
                  <option value="9">sep</option>
                  <option value="10">oct</option>
                  <option value="11">nov</option>
                  <option value="13">dec</option>

                </select>
                <br>
              <h4 style="color:blue;" >Distance</h4>
                <input style="margin-top:10px;" style="margin-top:20px;" type="text" name="txt_distance" placeholder="Distance from home" />
              
            <button style="margin-top:20px;" type="submit" value="addstudent" class="btn btn-primary btn-block btn-large">Add Applicant</button>
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
