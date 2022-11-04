<%@page import="context.DBContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="context.DBContext" %>
<%@ page import="java.sql.Connection" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/webcss.css">
</head>
<body>
<sql:setDataSource var = "ds" 
driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
url="jdbc:sqlserver://localhost:1433;databaseName=ShoppingDB;encrypt=true;trustServerCertificate=true;integratedSecurity=true;"
/>
<sql:query var="result" dataSource="${ds}" sql = "select * from products order by product_id" />
<div class="row body-center">
<c:forEach var = "pr" items="${result.rows}" varStatus="row">
		<form action="InformationProductController" method="post">
		<div class="card">
			<input type = "hidden" name="id" value="${pr.product_id}"/>
			<button id="img-point"><img width="200" src ="${pr.product_img_source}"></button>
			<h2>${pr.product_name}</h2>
			<p>$${pr.product_price}</p>
		</div>
		</form>
</c:forEach>
</div>
</body>
</html>