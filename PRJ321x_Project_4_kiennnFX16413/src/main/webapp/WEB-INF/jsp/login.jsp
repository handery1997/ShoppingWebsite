<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/CSS/webcss.css" />" rel="stylesheet">
</head>
<%
	String error= (String)request.getAttribute("error");
	if(error==null){
		error="";
	}
%>
<body>
<form action="login.html" method="post">
	<div class ="login">
		<h2>Login</h2>
		<input type="text" placeholder="username" name="username" id="username">
		<input type="password" placeholder="password" name="password" id="password">
		<button id="login-btn">Login</button>
		<p style="color:red;"><%=error%></p>
	</div>
</form>
</body>

</html>