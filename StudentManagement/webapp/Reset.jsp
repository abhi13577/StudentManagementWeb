<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset</title>
<style>
 body{
    background-image: linear-gradient(to right, #d87676, #0000006e);
    color: white;
}
form{
height:40vh;
width:50vw;
}
</style>
</head>
<body>
<center>
<%= (request.getAttribute("message")!=null)? request.getAttribute("message"): "" %>
 <form action="reset" method="post">
 <fieldset>
 <legend>Reset Password</legend>
 <label>Enter your email:</label><br>
 <input type="text" name="mail" placeholder="Enter your Email" required>
 <br>
 <br>
 <label>Enter your mobile:</label><br>
 <input type="tel" name="phone" placeholder="Enter your Phone" required>
 <br><br>
 <label>Enter your New Password:</label><br>
 <input type="password" name="pass" placeholder="Enter your new password" required>
 <br><br>
 <label>Confirm your password:</label><br>
 <input type="text" name="confirm" placeholder="Confirm Your password" required>
 <br><br>
 <input type="submit" value="Reset">
 </fieldset>
 </form>
 </center>
</body>
</html>