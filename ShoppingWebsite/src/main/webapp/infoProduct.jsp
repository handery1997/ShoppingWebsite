<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/webcss.css">
</head>
<body>
<jsp:include page = "header2.jsp"/>
<div class="row body-center">
<c:set var = "pr" value="${product}"/>
		<div class="card2">
			<img width="200" src ="${pr.getSrc()}">
			<h2>${pr.getName()}</h2>
			<p>${pr.getDescription()}</p>
			<p>$${pr.getPrice()}</p>
			<p>${pr.getId()}</p>
			<form action="AddToCartController" method="post">
				<input type = "hidden" name="idd" value="${pr.getId()}"/>
				<input type = "hidden" name="action" value="add">
				<button id="add-btn">Add To Cart</button>
			</form>
		</div> 
</div>
<jsp:include page = "footer.jsp"/>
</body>
</html>