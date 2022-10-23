<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/webcss.css">
</head>
<body>
<form action="Login" method="post">
	<div class ="login">
		<div class="login-entry">
			<h2>Login</h2>
			<input type="text" placeholder="username" name="username" id="username">
			<input type="password" placeholder="password" name="password" id="password">
			<br>
			<div class="spacing">
			<a href="#">Forgot your password?</a>
			</div>
			<br>
			<div>
			<input type="checkbox" id="remember" name="remember">
  			<label for="remember">Remember me</label>
  			</div>
  			<br>
			<button id="login-btn">Login</button>
		</div>
		<div class="login-welcome">
		<h2>Welcome Back!</h2>
		<p>To keep connect with us please login with your personal info</p>
		</div>
	</div> 
</form>
<%
	String error= (String) session.getAttribute("error");
  	String anou = (String) session.getAttribute("anou");
	if(error!=null){
		response.getWriter().println("<font color ='red'>"+error+"</font>");
	}
	if(anou!=null){
		response.getWriter().println("<font color ='red'>"+anou+"</font>");
	}
	session.setAttribute("error",null);
	session.setAttribute("anou",null);
%>


<script src="JavaScript/Script.js"></script>
</body>

</html>