<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="java.util.*" %>
<%@ page import="model.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/webcss.css">
</head>
<body>
<jsp:include page = "header2.jsp"/>
<div class="row body-center">
<c:forEach var = "pr" items="${products}">
		<form action="InformationProductController" method="post">
		<div class="card">
			<input type = "hidden" name="id" value="${pr.getId()}"/>
			<button id="img-point"><img width="200" src ="${pr.getSrc()}"></button>
			<h2>${pr.getName()}</h2>
			<p>$${pr.getPrice()}</p>
		</div>
		</form>
</c:forEach>
</div>
<jsp:include page = "footer.jsp"/>
</body>
</html>