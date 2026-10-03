<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
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
    color: white;
}
</style>
</head>
<body>
     <center>
 <h2>Welcome to Login page...!</h2>
 <%if(request.getAttribute("fail")!=null){ %>
 <%=request.getAttribute("fail") %>
 <%} %>
   <form action="login" method="post">
   <fieldset>
   <legend>Login Form</legend>
   <label>Enter your Email: </label><br>
   <input type="text" name="email" placeholder="Enter your email"><br><br><br>
   <br>
   <label>Enter your password:</label><br>
   <input type="password" name="password" placeholder="Enter your password">
   <br>
    <a href="Reset.jsp">Forgot Password?</a><br>
   <input type="submit" id="btn" value="Login">
   <p> Login with phone <a href="logph.jsp" alt="logph">Click Here</a></p>
   <p>For Signup? <a href="signup.jsp"  alt="Signup">Click Here</a>
   </fieldset>
   </form>
   </center>
</body>
</html>