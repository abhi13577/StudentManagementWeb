<%@page import="com.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Your Profile</title>
<style>
*{
margin: 0px;
padding: 0px;
font-family:cursive;
box-sizing:border-box;
}
header{
padding:30px;
background-color:black;
color:white;
height:70px;
width:100%;
display:flex;
justify-content: space-between;
align-items: center;
}
body{
background-color:grey;
}
main{
height:38vh;
}
table{
color:red;
background-color:white;
margin:50px auto;
height:30vh;
width:40vw;
border-collapse: collapse;
box-shadow: 0px 0px 8px white;
}
th,td{
padding:20px;
align-text:center;
}
button{
height:30px;
width:80px;
border:none;
border-radius:10px;
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
</style>
</head>
<body>
<% Student s = (Student)session.getAttribute("student"); %>
<header>
<h2>Welcome to view your profile</h2>
<a href="dashboard.jsp"><button>Back</button></a>
</header>
<table border="1">
<thead >
<tr>
<td>Sid</td>
<td>Sname</td>
<td>Email</td>
<td>Phone</td>
<td>Branch</td>
<td>Location</td>
</tr>
</thead>
<tr>
<td><%= s.getSid() %></td>
<td><%= s.getSname() %></td>
<td><%= s.getEmail() %></td>
<td><%= s.getPhone() %></td>
<td><%= s.getBranch() %></td>
<td><%= s.getLocation() %></td>
</tr>
</table>
<main></main>
<footer>
<h2>&copy; ALL RIGHTS RESERVED @ STUDENT APP</h2>
</footer>
</body>
</html>