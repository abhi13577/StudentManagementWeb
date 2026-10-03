<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logph</title>
<style>
 body{
    background-image: linear-gradient(to right, #d87676, #0000006e);
    color: white;
}
form{
height:40vh;
width:50vw;
}
#btn{
border: none;
    height: 22px;
    width: 60px;
    background-image: linear-gradient(to right, #c50e0e, #8d4848b3);
    color: white;}
</style>
</head>
<body>
 <center>
 <%= request.getAttribute("message")!=null ? request.getAttribute("message"): "" %>
  <h2>Welcome to Login page...!</h2>
  <form action="logphone" method="post">
  <fieldset>
  <legend>Login With Phone</legend>
  <legend>Enter your Phone number:</legend><br>
  <input type="tel" name="phone" placeholder="Enter your Phone"><br><br><br>
  <label>Enter your Password:</label><br>
  <input type="password" name="password" placeholder="Enter your Password"><br>
  <a href="Reset.jsp">Forgot Password?</a><br><br>
  <input type="submit" id="btn" value="Login">
   <p> Login with mail? <a href="login.jsp" alt="logph">Click Here</a></p>
   <p>For Signup? <a href="signup.jsp"  alt="Signup">Click Here</a>
  </fieldset>
  </form>
  </center>
</body>
</html>