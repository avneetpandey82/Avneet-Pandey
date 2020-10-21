<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CustCss/Cart.css">
<title>Cart</title>
</head>
<body>
	<div class="wrapper">
		
		
		<div class="heads">
			<h1>Welcome to FoodShala</h1>	
			<h3>A place to take a break</h3>
		</div>
	<ul>
		<li><h3>Welcome!<c:out value="${user}"></c:out></h3></li>
		<li><a href="CustMenuDisplay">Home</a></li>
		<li><a href="OrderList">MyOrder</a></li>
		<li><a href="CustLogout">Logout</a></li>
	</ul>
	<div class="logo">
		<img src="WebImages/logo.png">
	</div>
	
	<div class="title">
		<h2>Cart</h2>
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
		  <c:forEach items="${menu}" var="cust">
			  <tr>
			  	<th><%=i%></th>
			    <td>${cust.name}</td>
			    <td><img src="${cust.image}" width=100 height=100></td>
			    <td>${cust.type}</td>
			    <td>${cust.price}</td>
			    <td><a href="DeleteFromCart?id=${cust.id}">Delete</a></td>
			  </tr>
			  <%i++; %>
		  </c:forEach>
		</table>
	</div>
	<div class="sum">
		<h3>Total : <c:out value="${sum}"></c:out></h3>
	</div>
	<div class="order">
		<a href="Order">Order</a>
	</div>
</div>
</body>
</html>