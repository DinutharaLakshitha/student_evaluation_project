<%@page import="javax.websocket.Session"%>
<%@page import="java.io.IOException"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.ArrayList"%>
<%
    String occupation = "none";
    try {

        if (session.getAttribute("uname") == null) {
            response.sendRedirect("index.jsp");
        } else {
            occupation = (String) session.getAttribute("occupation");
            if (!occupation.equals("interviewer")) {
                response.sendRedirect("index.jsp");
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
                <%}%>
                <% if (occupation.equals("interviewer")) {%>
                <a href="interviewStudent.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small w3-orange">INTERVIEW STUDENT</a>
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
            <%}%>
            <% if (occupation.equals("interviewer")) {%>
            <a href="interviewStudent.jsp" class="w3-bar-item w3-button w3-padding-large w3-orange">INTERVIEW STUDENT</a>
            <%}%>
            <a href="Logout" class="w3-bar-item w3-button w3-padding-large">LOG OUT</a>

        </div>

        <!-- Page content -->
        <div class="w3-content" style="max-width:2000px;margin-top:46px">
            <div class ="login">
                <form method ="post" action="putMarks">
                    <Text>Interviewer : <% out.println(session.getAttribute("uname")); %></Text>
                    <br>
                    <Text>School : <% out.println(session.getAttribute("school")); %></Text>
                    <br>
                    <Text>Input marks for Applicant :<% out.println(session.getAttribute("applicant")); %></Text>
                    <br>
                    <Text> School id : <% out.println(session.getAttribute("school_id")); %></Text>
                    <br>
                    <text>View Reference student's details</text>
                    <br><br>


                    <button type="button" class="btn btn-primary btn-block btn-large" value="view" onclick ="window.open('StudentDetailView')"> View Referees</button>



                    <br>
                    Questionare marks :<br>
                    <input type="text" value ="0" name="mark1">
                    <br>
                    Other Marks :<br>
                    <input type="text" value="0" name="mark2">
                    <br>
                    Marks for distance:
                    <%Object dist_mark = session.getAttribute("dist_mark");%>
                    <br>
                    <input type="text" name="txtDistance" value="<%out.println(dist_mark);%>" disabled="disabled" />
                    <br><br>
                    <button type="submit" class="btn btn-primary btn-block btn-large">Submit</button>  
                </form>     
            </div>

            <!-- End Page Content -->
        </div>

    </body>
</html>