<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel = "stylesheet" href="../CustCss/Registration.css">
<title>Customer Registration</title>
</head>
<body>
	<!-- <h1>Welcome to FoodShala</h1>
	<h6>A place to take a break</h6> -->
	<div class="logo">
		<img src="../WebImages/logo.png">
	</div>
	<div class="wrapper">
    <form action="../CustRegistration" method="post">
 		<h1>SignUp as Customer </h1>
    	<p>Name:<input type="text" name="name" placeholder="Enter Your Name"></p>
    	<p>Date Of Birth: <input type="date" name="dob" placeholder="Date"></p>
    	<p>Phone Number: <input type="number" name="pnumber" placeholder="Enter Your Phone Number"></p>
    	<p>Address: <input type="text" name="address" placeholder="Enter Your Address"></p>
    	<p>Gender:<h5><input type="radio" name="gender" value="Male">Male
    		   <input type="radio" name="gender" value="Female">Female
    		   <input type="radio" name="gender" value="Others">Others</h5></p>
    	<p>Food Preference: <h5><input type="radio" name="preference" value="Veg">Veg
        				<input type="radio" name="preference" value="Non-Veg">Non-Veg</h5>
    	</p>
    	<p>Username: <input type="email" name="uname" placeholder="Enter your Username"></p>
    	<p>Password: <input type="password" name="password" placeholder="Enter your Password"></p>                
    	<input type="submit" value="Submit" ><br>  
    	</form>
	<a href="../RedirectCustLogin">Have a Account?</a>
	</div>
</body>
</html>