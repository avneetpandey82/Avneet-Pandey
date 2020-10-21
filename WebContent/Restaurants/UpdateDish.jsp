<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel = "stylesheet" href="RestCss/UpdateDish.css">
<title>Update Dish</title>
</head>
<body>
<div class="main">
	<div class="title">
		<h1>Welcome to FoodShala</h1>
		<h6>A place to take a break</h6>
	</div>
	<div class="logo">
		<img src="WebImages/logo.png">
	</div>
	<div class="list">
		<ul>
			<li><a href="RestLogout">Logout</a></li>
			<li><a href="RestMenuDisplay">Home</a></li>
		</ul>
	</div>
	<div class="wrapper">
	
	<h1>Update Details</h1>
	<form action="RestMenuUpdate" method="post">
		<c:forEach items="${list}" var="items">
		<p>Id:<input  type="text" name="id" value="${items.id}"></p>
		<p>Name: <input type="text" name="dishName" value="${items.name}"></p>
		<p>Image(path): <input type="text" name="dishImage" value="${items.image}"></p>
		<p>Type:<input type="radio" value="Veg" name="dishType" ${items.type == 'Veg'?'checked':''}>Veg
				<input type="radio" value="Non-Veg" name="dishType" ${items.type == 'Non-Veg'?'checked':''}>Non-Veg</p>
		<p>Price:<input type="number" name="dishPrice" value="${items.price}"></p>
		<p><input type="submit" value="Submit"></p>
		</c:forEach>
	</form>
	</div>
</div>
</body>
</html>