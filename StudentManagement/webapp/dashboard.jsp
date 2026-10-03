<%@page import="com.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<style>
* {
    margin: 0px;
    padding: 0px;
    font-family: cursive;
    box-sizing: border-box;
}

body {
    background-color: grey;
    min-height: 100vh;
    display: flex;
    flex-direction: column;
}

.head {
    background-color: black;
    color: white;
    height: 70px;
    width: 100%;
    display: flex;
    justify-content: space-between; /* Pushes welcome line and button to opposite corners */
    align-items: center;            /* Centers items vertically */
    padding: 0 25px;                /* Adds spacing so items don't touch screen edges */
}

.mains {
    flex: 1;                        /* Allows main section to fill remaining height */
    display: flex;
    justify-content: center;        /* Centers content horizontally */
    align-items: center;            /* Centers content vertically */
    text-align: center;
    height:80vh;
}

footer {
    background-color: black;
    color: white;
    height: 70px;
    width: 100%;
    display: flex;
    justify-content: center;        /* Centers footer content horizontally */
    align-items: center;            /* Centers footer content vertically */
}

/* Optional styling for the button */
.btn button {
    padding: 6px 16px;
    cursor: pointer;
    font-size: 14px;
    font-family: inherit;
}
</style>
</head>
<body>

  <header>
  <div class="head">
  <div class="ann">
   <p>Wellcome <% Student s = (Student)session.getAttribute("student");%>
<%= s.getSname() %>
  </div>
    <div class="btn">
    <% if(s.getSid()==1){ %>
    <a href="viewStudents"><button>View Student</button></a>
    <% } %>
    <a href="profile.jsp"><button>View Profile</button></a>
   <a href="edit.jsp"><button>Edit</button></a>
    <a href="logout"><button>Logout</button></a>
    </div>
    </div>
  </header>
  <main>
  <div class="mains">
   <p>Login Sucessfull This is your student profile</p><br>
   <%=(request.getAttribute("message")!=null)?request.getAttribute("message"):"" %>
  </div>
  </main>
  <footer>
  <div class="close">
  <p>&copy; All Rights Reserved 2026 </p>
  </div>
  </footer>

</body>
</html>