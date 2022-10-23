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
<div class="row">
	<div class="leftcolumn">
		<div class="card">
		<h2>Information of product 1</h2>
		<h5>Title description, Dec 7, 2017</h5>
		<div class="fakeimage" style="height:200px">Image</div>
		<p>Some text...</p>
		</div>
		<div class="card">
			<h2>Information of product 2</h2>
			<h5>Title description, Dec 7, 2017</h5>
			<div class="fakeimage" style="height:200px">Image</div>
			<p>Some text...</p>
		</div>
	</div>
	<div class="rightcolumn">
		<div class="card">
			<h2>Shopping cart</h2>
			<div class="fakeimg" style="height:200px">Cart</div>
			<p>Summary information of your card can be displayed here!</p>
		</div>
		<div class="card">
			<h3>Popular products of banners</h3>
			<div class="fakeimg"><p>Image</p></div>
			<div class="fakeimg"><p>Image</p></div>
			<div class="fakeimg"><p>Image</p></div>
		</div>
	</div>
</div>
</body>
</html>