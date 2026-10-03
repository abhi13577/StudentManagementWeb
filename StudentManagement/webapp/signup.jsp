<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<style>
   body{
   background-image:linear-gradient(to right, #701bc0, #4dc84d);
   color:white;
   }
   form{
    height:60vh;
    width:50vw;
   }
   #btn{
   background-image:linear-gradient(to right,#b81080,blue);
   border: none;
    size: 20px;
    color: white;
    padding-top: 2px;
    padding-bottom: 2px;
    padding-right: 12px;
    padding-left: 12px;
   }
</style>
</head>
<body>
<center>
    <%if(request.getAttribute("pass")!=null){ %>
    <%= request.getAttribute("pass") %>
    <%} %>
    <%if(request.getAttribute("fail")!=null){ %>
    <%= request.getAttribute("fail") %>
    <%} %>
    
	<h2>Hello Welcome to Student Management Website...!</h2>
		<form action="signup" method="post">
		<fieldset>
		<legend>Signup Form</legend>
		   <label>Enter your Name: </label><br>
			<input type="text" name="name" placeholder="Enter your name">
			<br><br> 
			<label>Enter your number: </label><br><input type="tel" name="phone"
				placeholder="Enter your phone"><br>
			<br>
			 <label>Enter your mail id: </label><br><input type="text" name="email"
				placeholder="Enter your email"><br>
			<br>
			 <label>Enter your location: </label><br><input type="text" name="loc"
				placeholder="Enter your location"><br>
			<br> 
			<label>Enter your branch: </label><br><input type="text" name="branch"
				placeholder="Enter your branch"><br>
			<br>
			 <label>Enter your password: </label><br><input type="password" name="password"
				placeholder="Enter your pass"><br>
			<br>
			 <label>Confirm your password: </label><br><input type="text" name="confirm"
				placeholder="Enter your confirm"><br>
			<br> <input type="submit" id="btn" value="Signup"><br>
			<br>
			<p>
				If you have an account for Login? <a href="login.jsp" alt="login">Click
					Here</a>
			</p>
			</fieldset>
		</form>
	</center>
</body>
</html>