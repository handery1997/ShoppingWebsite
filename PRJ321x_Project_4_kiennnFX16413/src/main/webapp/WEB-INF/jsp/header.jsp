<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/CSS/webcss.css" />" rel="stylesheet">
</head>
<body>
<% 
String name = (String)request.getAttribute("username"); 
%>
<div class="header">
	<h1>Welcome <%= name != null ? name+" ":"" %>to my website</h1>
	<img src="<c:url value="/resources/Logo.png"/>" alt="Logo">
</div>
<div class="topnav">
	<a href="#" class="nav-link">Home</a>
	<a href="#" class="nav-link">Products</a>
	<a href="#" class="nav-link">About us</a>
	<a href=<%= name!=null ?"#":"login.html"%> class="login-header"><%= name!=null? "Logout" : "Login"%></a>
</div>
</body>
</html>