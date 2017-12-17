<%@page import="java.sql.ResultSet"%>
<%
    String occupation = "none";
    try {

        if (session.getAttribute("uname") == null) {
            //response.sendRedirect("index.jsp");
        } else {
            occupation = (String) session.getAttribute("occupation");
            if (!occupation.equals("interviewer")) {
                //response.sendRedirect("index.jsp");
            }
        }
    } catch (Exception e) {
    }


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <title>Interview Student</title>
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
        <% if (occupation.equals("admin")) {%>
        <a href="registerUser.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">ADD USER</a>
        <%}%>
        <% if (occupation.equals("dataEntry")) {%>
        <a href="addApplicant.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">ADD APPLICANT</a>
        <a href="addSchool.jsp" class="w3-bar-item w3-button w3-padding-large">ADD SCHOOL</a>
        <%}%>
        <% if (occupation.equals("interviewer")){%>
  <a href="interviewStudent.jsp" class="w3-bar-item w3-button w3-padding-large w3-orange">INTERVIEW STUDENT</a>
  <a href="forwardResults" class="w3-bar-item w3-button w3-padding-large">VIEW RESULTS</a>
<%}%>
        <a href="Logout" class="w3-bar-item w3-button w3-padding-large w3-hide-small w3-right">LOG OUT</a>


    </div>
</div>

<!-- Navbar on small screens -->
<div id="navDemo" class="w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top" style="margin-top:46px">
    <a href="ViewProfile" class="w3-bar-item w3-button w3-padding-large">VIEW PROFILE</a>
    <a href="changePassword.jsp" class="w3-bar-item w3-button w3-padding-large">CHANGE PASSWORD</a>
    <% if (occupation.equals("admin")) {%>
    <a href="registerUser.jsp" class="w3-bar-item w3-button w3-padding-large">ADD USER</a>
    <%}%>
    <% if (occupation.equals("dataEntry")) {%>
    <a href="addApplicant.jsp" class="w3-bar-item w3-button w3-padding-large">ADD APPLICANT</a>
    <a href="addSchool.jsp" class="w3-bar-item w3-button w3-padding-large">ADD SCHOOL</a>
    <%}%>
    <% if (occupation.equals("interviewer")){%>
  <a href="interviewStudent.jsp" class="w3-bar-item w3-button w3-padding-large w3-orange">INTERVIEW STUDENT</a>
  <a href="forwardResults" class="w3-bar-item w3-button w3-padding-large">VIEW RESULTS</a>
<%}%>
    <a href="Logout" class="w3-bar-item w3-button w3-padding-large">LOG OUT</a>

</div>


        <!-- Page content -->

        <div class="w3-content" style="max-width:2000px;margin-top:46px">

            <div class ="login">
                <form method ="post" action="searchApplicant">
                    <%if(session.getAttribute("success")!=null){%><label class="label_ok"> Successfully Entered </label><br><br><%}%>
                    <h2>Search by Applicant ID</h2>
                    <%try {
                            if (session.getAttribute("error") != null) {%>  
                    <br>
                    <center> <label class="label_error" style="padding-left:55px;padding-right: 55px;"><%String error = (String) session.getAttribute("error");
                        session.removeAttribute("error");
                        out.print(error);%> </label></center> 
                            <%}
                                } catch (Exception e) {
                                }%>
                    <input type="text" name="applicant_id">
                    <br><br>
                    <button type="submit" class="btn btn-primary btn-block btn-large">Search</button>


                    <% ResultSet resultset = (ResultSet) session.getAttribute("resultset");
                        if (resultset != null) {%>
                    <h2>Select School</h2>
                    <br>
                    <select class="select" name="school">
                        <%  while(resultset.next()){ %>
                        <option><%=resultset.getString("name")%></option>
                    
                    <%}}%>
                    </select>
                    <br><br>
                    <button type="submit" class="btn btn-primary btn-block btn-large" onclick="form.action = 'forwardInterviewerDetails'"> Start Interview </button>
                    
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
                if (myIndex > x.length) {
                    myIndex = 1;
                }
                x[myIndex - 1].style.display = "block";
                setTimeout(carousel, 4000);
            }

            // Used to toggle the menu on small screens when clicking on the menu button
            function myFunction() {
                var x = document.getElementById("navDemo");
                if (x.className.indexOf("w3-show") === -1) {
                    x.className += " w3-show";
                } else {
                    x.className = x.className.replace(" w3-show", "");
                }
            }

            // When the user clicks anywhere outside of the modal, close it
            var modal = document.getElementById('ticketModal');
            window.onclick = function (event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        </script>

    </body>
</html>


