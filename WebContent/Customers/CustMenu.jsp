<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CustCss/CustMenu.css">
<title>FoodShala</title>
</head>
<body>
<%
		String user =(String)session.getAttribute("user");
		String x=null;
	%>
	
	<div class="wrapper">
		
		
		<div class="heads">
			<h1>Welcome to FoodShala</h1>	
			<h3>A place to take a break</h3>
		</div>

		<c:choose>
			<c:when test="${user==x}">	
				<ul>
				<li><a href="CustMenuDisplay">Home</a></li>
				<li><a href="RedirectCustLogin">Login</a></li>
				</ul>
			</c:when>
			<c:otherwise>
				<ul>
				<li><h3>Welcome!<c:out value="${user}"></c:out></h3></li>
				<li><a href="CustMenuDisplay">Home</a></li>
				<li><a href="Cart">Cart</a></li>
				<li><a href="OrderList">MyOrder</a></li>
				<li><a href="CustLogout">Logout</a></li>
				</ul>
			</c:otherwise>
		</c:choose>	
		</div>
			<div class="logo">
			<img src="WebImages/logo.png">
		</div>
		<div class="table-box">
			<table border="1px">
			  <tr>
			    <th>S.No.</th>
			    <th>Name</th>
			    <th>Image</th>
			    <th>Type</th>
			    <th>Price</th>
			    <th>Action</th>
			  </tr>
			  <% int i=1; %>
			  <c:forEach items="${list}" var="rest">
				  <tr>
				  	<th><%=i%></th>
				    <td>${rest.name}</td>
				    <td><img src="${rest.image}" width=100 height=100></td>
				    <td>${rest.type}</td>
				    <td>${rest.price}</td>
				    <td><a href="AddToCart?id=${rest.id}">Add</a></td>
				  </tr>
				  <%i++; %>
			  </c:forEach>
			</table>
		</div>
</body>
</html>