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
<%
	int flag=0;
%>
<jsp:useBean id = "account" class ="model.Account" scope = "session"/> 
<jsp:setProperty property="name" name="account" value="kien"/>
<jsp:include page = "header2.jsp"/>
<div class="row body-center">
	<div class="card2">
<form id= "myform" action="PayController" method="post">
<table>
	<thead>
	<tr>
		<th scope="col">Product ID</th>
		<th scope="col">Name</th>
		<th scope="col">Type</th>
		<th scope="col">Price</th>
		<th scope="col">Amount</th>
		<th scope="col">Cancel</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var = "ca" items="${cartItems}" varStatus="loop">
				<tr>
					<td>${ca.getId()}</td>
					<td>${ca.getName()}</td>
					<td>${ca.getType()}</td>
					<td>${ca.getPrice()}</td>
					<td><input type="text" inputmode="numeric" pattern="\d*" name="amount<%=flag%>" value="${ca.getNumber()}"></td>
					<td>
							<input type = hidden name="idd<%=flag%>" value="${ca.getId()}">
							<input type =submit  id="dlt-btn" name="action<%=flag%>"value="Delete">
						</td>
					<% flag+=1;%>
				</tr>
		</c:forEach>
	</tbody>		
</table>
	<%session.setAttribute("flag",flag);%>
	<input type = submit id="pay-btn" name="action" value="Pay">
</form>
</div>
</div>

<%
	String cartError= (String) session.getAttribute("cartError");
	if(cartError!=null){
		response.getWriter().println("<font color ='red'>"+cartError+"</font>");
		session.setAttribute("cartError",null);
	}
%>
<jsp:include page = "footer.jsp"/>
</body>
</html>