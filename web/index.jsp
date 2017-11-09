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
<style>
.label_error { 
	width: 100%; 
	margin-bottom: 10px; 
	text-align: center;
	background: rgba(20,0,0,0.3);
	border: none;
	outline: none;
	padding: 10px;
	padding-left:55px;
	padding-right:55px;
	font-size: 13px;
	color: #fff;
	text-shadow: 1px 1px 1px rgba(255,0,0,0.3);
	border: 1px solid rgba(255,0,0,0.3);
	border-radius: 4px;
	box-shadow: inset 0 -5px 45px rgba(255,100,100,0.2), 0 1px 1px rgba(255,255,255,0.2);
}
</style>

</head>

<body>
  <div class="login">
	<h1>Login</h1>
    <form method="post" action="Login">
        
        <%try{
        if (session.getAttribute("error")!=null){%> 
        <!--style="padding-left:55px;padding-right: 55px;"-->
            <label class="label_error" style="text-align:center;" ><%String error =(String)session.getAttribute("error");
            session.removeAttribute("error"); out.print(error);%> </label>
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
