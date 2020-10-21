<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../RestCss/Registration.css">
<title>Restaurant Registration</title>
</head>
<body>
	<!-- <h1>Welcome to FoodShala</h1>
	<h6>A place to take a break</h6>-->
	
	<div class="logo">
		<img src="../WebImages/logo.png">
	</div>
	<div class="wrapper">
	 <form action="../RestRegistration">
	 	<h1>SignUp as staff </h1>
     	<p>Name:<input type="text" name="name" placeholder="Enter Your Name"></p>
     	<p>Dob: <input type="date" name="dob"></p>
        <p>Phone Number: <input type="number" name="pnumber" placeholder="Enter Your Phone Number"></p>
        <p>Address: <input type="text" name="address" placeholder="Enter Your Address"></p>
        <p>Gender: <input type="text" name="gender" placeholder="Enter Your Gender"></p>
        <p>Username: <input type="email" name="uname" placeholder="Enter your Username"></p>
        <p>Password: <input type="password" name="password" placeholder="Enter your Password"></p>              
        <input type="submit" value="Submit" ><br>  
		<a href="../RedirectRestLogin">Have a Account?</a>
	 </form>
	</div>
</body>
</html>