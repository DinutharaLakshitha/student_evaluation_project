<%
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
    
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<title>Home</title>
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
    <a href="home.jsp" class="w3-bar-item w3-button w3-padding-large w3-orange">HOME</a>
    <a href="ViewProfile" class="w3-bar-item w3-button w3-padding-large w3-hide-small">VIEW PROFILE</a>
    <a href="changePassword.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">CHANGE PASSWORD</a>
    <% if (occupation.equals("admin")){%>
          <a href="registerUser.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">ADD USER</a>
    <%}%>
    <% if (occupation.equals("dataEntry")){%>
          <a href="addApplicant.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">ADD APPLICANT</a>
          <a href="addSchool.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">ADD SCHOOL</a>
    <%}%>
    <% if (occupation.equals("interviewer")){%>
          <a href="interviewStudent.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">INTERVIEW STUDENT</a>
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
          <a href="addSchool.jsp" class="w3-bar-item w3-button w3-padding-large">ADD SCHOOL</a>
  <%}%>
  <% if (occupation.equals("interviewer")){%>
          <a href="interviewStudent.jsp" class="w3-bar-item w3-button w3-padding-large">INTERVIEW STUDENT</a>
          <a href="forwardResults.java" class="w3-bar-item w3-button w3-padding-large">VIEW RESULTS</a>
  <%}%>
  <a href="Logout" class="w3-bar-item w3-button w3-padding-large">LOG OUT</a>
 
</div>
  
  
<!-- Page content -->
<div class="w3-content" style="max-width:2000px;margin-top:46px">
  
<!-- End Page Content -->
</div>

<canvas id="canvas" width="400" height="400"
style="text-align: center;">
</canvas>

<script>
var canvas = document.getElementById("canvas");
canvas.setAttribute('style', "position: absolute;  left: 50%;margin-left:-200px; top: 50%;margin-top:-200px;");
var ctx = canvas.getContext("2d");
var radius = canvas.height / 2;
ctx.translate(radius, radius);
radius = radius * 0.90
setInterval(drawClock, 1000);

function drawClock() {
  drawFace(ctx, radius);
  drawNumbers(ctx, radius);
  drawTime(ctx, radius);
}

function drawFace(ctx, radius) {
  var grad;
  ctx.beginPath();
  ctx.arc(0, 0, radius, 0, 2*Math.PI);
  ctx.fillStyle = 'white';
  ctx.fill();
  grad = ctx.createRadialGradient(0,0,radius*0.95, 0,0,radius*1.05);
  grad.addColorStop(0, '#333');
  grad.addColorStop(0.5, 'white');
  grad.addColorStop(1, '#333');
  ctx.strokeStyle = grad;
  ctx.lineWidth = radius*0.1;
  ctx.stroke();
  ctx.beginPath();
  ctx.arc(0, 0, radius*0.1, 0, 2*Math.PI);
  ctx.fillStyle = '#333';
  ctx.fill();
}

function drawNumbers(ctx, radius) {
  var ang;
  var num;
  ctx.font = radius*0.15 + "px arial";
  ctx.textBaseline="middle";
  ctx.textAlign="center";
  for(num = 1; num < 13; num++){
    ang = num * Math.PI / 6;
    ctx.rotate(ang);
    ctx.translate(0, -radius*0.85);
    ctx.rotate(-ang);
    ctx.fillText(num.toString(), 0, 0);
    ctx.rotate(ang);
    ctx.translate(0, radius*0.85);
    ctx.rotate(-ang);
  }
}

function drawTime(ctx, radius){
    var now = new Date();
    var hour = now.getHours();
    var minute = now.getMinutes();
    var second = now.getSeconds();
    //hour
    hour=hour%12;
    hour=(hour*Math.PI/6)+
    (minute*Math.PI/(6*60))+
    (second*Math.PI/(360*60));
    drawHand(ctx, hour, radius*0.5, radius*0.07);
    //minute
    minute=(minute*Math.PI/30)+(second*Math.PI/(30*60));
    drawHand(ctx, minute, radius*0.8, radius*0.07);
    // second
    second=(second*Math.PI/30);
    drawHand(ctx, second, radius*0.9, radius*0.02);
}

function drawHand(ctx, pos, length, width) {
    ctx.beginPath();
    ctx.lineWidth = width;
    ctx.lineCap = "round";
    ctx.moveTo(0,0);
    ctx.rotate(pos);
    ctx.lineTo(0, -length);
    ctx.stroke();
    ctx.rotate(-pos);
}
</script>

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


