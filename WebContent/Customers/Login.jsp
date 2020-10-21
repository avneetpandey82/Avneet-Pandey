<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href = "CustCss/Login.css">
<title>Customer Login</title>
</head>
<body>

	<div class="logo">
		<img src="WebImages/logo.png">
	</div>
	
	<div class="wrapper">
		<h1>Sign in</h1>
		<form action="CustLogin" method="post">
			<h2>Username:<input type="text" name="username" placeholder="Enter your Username"></h2>
			<h2>Password:<input type="password" name="password" placeholder="Enter your Password"></h2>
			<input type="submit" value="Submit">
			<a href="Customers/Registration.jsp">Don't have an account</a>
		</form>
	</div>
</body>
</html>