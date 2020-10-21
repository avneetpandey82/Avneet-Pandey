<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel = "stylesheet" href="../RestCss/AddDish.css">
<title>Add Dish</title>
</head>
<body>
<div class="main">
	<div class="title">
		<h1>Welcome to FoodShala</h1>
		<h6>A place to take a break</h6>
	</div>
	<div class="logo">
		<img src="../WebImages/logo.png">
	</div>
	<div class="list">
		<ul>
			<li><a href="../RestLogout">Logout</a></li>
			<li><a href="../RestMenuDisplay">Home</a></li>
		</ul>
	</div>
	<div class="wrapper">
	
	<h1>Add Item</h1>
	<form action="../AddDish" method="post">
		<p>Name: <input type="text" name="dishName"></p>
		<p>Image(path): <input type="text" name="dishImage"></p>
		<p>Type:<input type="radio" value="Veg" name="dishType">Veg
				<input type="radio" value="Non-Veg" name="dishType">Non-Veg</p>
		<p>Price:<input type="number" name="dishPrice"></p>
		<p><input type="submit" value="Submit"></p>
	</form>
	</div>
</div>
</body>
</html>