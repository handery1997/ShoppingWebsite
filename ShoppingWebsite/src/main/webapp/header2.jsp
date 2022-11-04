<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/webcss.css">
</head>
<body>
<% 
String name = (String)session.getAttribute("user"); 
String rem="";
Cookie ck[]=request.getCookies();
if(ck!=null){
	for (int i=0;i<ck.length;i++){
		if(ck[i].getName().equals("cookRem")){
			rem=ck[i].getValue();
		}
	}
}
%>
<div class="header">
	<div class="header-welcome">
		<h1>Welcome <%= name != null ? name+" ":"" %>to my website</h1>
		<img src="Logo.png" alt="Logo">
	</div>
	<div class="search-bar">
		<form action = "SearchController" method=post>
		<select name="Select" style="height:40px; width:100px">
    		<option value="category">Category</option>
    		<option value="id">ID</option>
    		<option value="name">Name</option>
  		</select>
		<input type="text" placeholder="Search.." name="Search" style="height:40px; width:600px">
      	<button type="submit"style="height:40px; width:60px">Submit</button>
      	</form>
	</div>
</div>
<div class="topnav">
	<a href="home2.jsp" class="nav-link">Home</a>
	<a href="#" class="nav-link">Products</a>
	<a href="#" class="nav-link">About us</a>
	<a href=<%= name!=null ?"logout.jsp":"login.jsp"%> class="login-header"><%= name!=null? "Logout" : "Login"%></a>
</div>
</body>
</html>