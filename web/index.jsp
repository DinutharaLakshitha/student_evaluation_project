<%
    try{
        String n =(String)session.getAttribute("uname");
        if(n.length()>3){
            response.sendRedirect("home.jsp");
        }
    }catch(Exception e){
    }
%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>~Welcome~</title>
  
<link rel="stylesheet" href="css/style_index.css">

</head>

<body>
  <div class="login">
	<h1>Login</h1>
    <form method="post" action="Login">
        
        <%try{
        if (session.getAttribute("error")!=null){%>        
            <center> <label class="label_error" style="padding-left:55px;padding-right: 55px;"><%String error =(String)session.getAttribute("error");
            session.removeAttribute("error"); out.print(error);%> </label></center> 
        <%}
        }catch(Exception e){
        }%>
        
    	<input style="margin-top:20px;" type="text" name="uname" placeholder="Username" required="required" autofocus="true"/>
        <input type="password" name="pass" placeholder="Password" required="required" />
        <button type="submit" value="Login" class="btn btn-primary btn-block btn-large">Login</button>
    </form>
</div>
  
    

</body>
</html>
