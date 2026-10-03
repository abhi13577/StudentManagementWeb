<%@page import="com.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit your Profile</title>
<style>
*{
margin:0px;
padding:0px;
box-sizing:border-box;
}
body{
background-color:grey;
}
header{
background-color:black;
color:white;
height:70px;
width:100%;
display:flex;
align-items:center;
justify-content:space-between;
}
footer{
background-color:black;
color:white;
height:70px;
width:100%;
display:flex;
align-items:center;
justify-content:center;
}
main{
width:100%;
height:75vh;
}
button{
background-color:green;
color:white;
border:none;
border-radius:10px;
height:40px;
width:100px;
padding:10px;
margin:20px;
font-size:large;
}
button:hover{
background-color:blue;
color:white;
border:none;
border-radius:10px;
height:40px;
width:100px;
padding:10px;
margin:20px;
font-size:large;
}
.forms{
height:40vh;
width:30vw;
background-color:white;
box-shadow:0px 0px 8px red;
border-radius:10px;
margin:50px auto;
padding:20px;

}

input{
height:40px;
width:400px;
margin:10px auto;
text-align:center;
border-top:none;
border-left:none;
border-right:none;
background-color:pink;
font-size:large;
}
</style>
</head>
<body>
<header>

<h2>Welcome Edit Your Profile</h2>

<a href="dashboard.jsp"><button>Back</button></a>
</header>
<main>
<% Student s = (Student)session.getAttribute("student"); %>
<%= (request.getAttribute("message")!=null)?request.getAttribute("message"):"" %>
<div class="forms">
 <form action="edit" method="post">
 <input type="text" name="name" value="<%=s.getSname()%>"><br>
 <input type="text" name="branch" value="<%=s.getBranch()%>"><br>
 <input type="text" name="location" value="<%=s.getLocation()%>"><br>
 <button  type="submit">Update</button>
 </form>
</div>
</div>
</main>
<footer>
<h2>&copy; ALL RIGHTS RESERVED @ STUDENT APP</h2>
</footer>
</body>
</html>