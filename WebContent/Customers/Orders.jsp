<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CustCss/Order.css">
<title>Orders</title>
</head>
<body>
<div class="wrapper">
		<div class="heads">
			<h1>Welcome to FoodShala</h1>	
			<h3>A place to take a break</h3>
		</div>
	<ul>
		<li><a href="CustMenuDisplay">Home</a></li>
		<li><a href="CustLogout">Logout</a></li>
	</ul>
	<div class="logo">
		<img src="WebImages/logo.png">
	</div>
	<div class="title">
		<h2>Your Orders</h2>
	</div>
		<div class="table-box">
			<table border="1px">
				  <tr>
				    <th>S.No.</th>
				    <th>Name</th>
				    <th>Image</th>
				    <th>Type</th>
				    <th>Price</th>
				  </tr>
				  <% int i=1; %>
				  <c:forEach items="${orderList}" var="rest">
					  <tr>
					  	<th><%=i%></th>
					    <td>${rest.name}</td>
					    <td><img src="${rest.image}" width=100 height=100></td>
					    <td>${rest.type}</td>
					    <td>${rest.price}</td>
					  </tr>
					  <%i++; %>
				  </c:forEach>
			</table>
		</div>
</div>
</body>
</html>