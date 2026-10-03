<%@page import="com.studentapp.dto.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Students</title>
<style>
*{
margin: 0px;
padding: 0px;
font-family: cursive;
box-sizing: border-box;
}
header{
background-color: black;
color:white;
height:70px;
width:100%;
display:flex;
align-items: center;
justify-content: space-between;
padding: 20px;
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
button{
height:30px;
width:80px;
border:none;
font-size:large;
border-radius: 10px;
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
body{
background-color: grey;
}
</style>
</head>
<body>
<header>
<h2>View Students List</h2>
<a href="dashboard.jsp"><button>Back</button></a>
</header>
	<%=(request.getParameter("message") != null) ? request.getParameter("message") : ""%>

	<%
	ArrayList<Student> list = null;
	%>
	<%
	if (request.getAttribute("li") != null) {
	%>

	<%
	list = (ArrayList) request.getAttribute("li");
	%>
	<%
	}
	%>
	<table border="1">
		<thead>
			<tr>
				<th>Sid</th>
				<th>Sname</th>
				<th>Branch</th>
				<th>Email</th>
				<th>Location</th>
				<th>Phone</th>
				<th>Action</th>
			</tr>
		</thead>

		<%
		for (Student s : list) {
		%>

		<tr>
			<td><%=s.getSid()%></td>
			<td><%=s.getSname()%></td>
			<td><%=s.getBranch()%></td>
			<td><%=s.getEmail()%></td>
			<td><%=s.getLocation()%></td>
			<td><%=s.getPhone()%></td>
			<td><button>
					<a href="Delete?sid=<%=s.getSid()%>">Delete</a>
				</button></td>
		</tr>
		<%
		}
		%>

	</table>
	<footer>
<h2>&copy; ALL RIGHTS RESERVED @ STUDENT APP</h2>
</footer>
</body>
</html>