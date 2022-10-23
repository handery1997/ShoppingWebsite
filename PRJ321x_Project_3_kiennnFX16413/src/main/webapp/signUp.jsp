<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/webcss.css">
</head>
<body>
<form action="SignUpController" method="post">
	<div class ="login">
		<div class="login-entry">
			<h2>Sign Up</h2>
			<input type="text" placeholder="username" name="username" id="username">
			<input type="password" placeholder="password" name="password" id="password">
  			<br>
			<button id="login-btn">Sign Up</button>
		</div>
		<div class="login-welcome">
		<h2>Welcome To Our Website!</h2>
		<p>To keep connect with us please sign up new account</p>
		</div>
	</div> 
</form>
<%
	String error= (String) session.getAttribute("error");
	if(error!=null){
		response.getWriter().println("<font color ='red'>"+error+"</font>");
	}
%>


<script src="JavaScript/Script.js"></script>
</body>

</html>