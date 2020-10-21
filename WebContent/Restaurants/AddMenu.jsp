<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>  
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="RestCss/AddMenu.css">
		<title>Menu</title>
	</head>
<body>
<div class="wrapper">
				
		<div class="heads">
			<h1>Welcome to FoodShala</h1>
			<h3>A place to take a break</h3>
		</div>
	<div class="add">
		<a href="Restaurants/AddDish.jsp">Add Item</a>
	</div>
	<ul>
		<li><a href="RestLogout">Logout</a></li>
	</ul>
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
			    <td><a href="RestMenuDelete?id=${rest.id}">Delete</a><a href="RestMenuUpdate1?id=${rest.id }">Update</a></td>
			  </tr>
			  <%i++; %>
		  </c:forEach>
		</table>
	</div>
</div>
</body>
</html>