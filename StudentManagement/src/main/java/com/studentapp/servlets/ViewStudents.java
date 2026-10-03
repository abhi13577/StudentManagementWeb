package com.studentapp.servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.studentapp.dao.StudentDaoImp;
import com.studentapp.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewStudents")
public class ViewStudents extends HttpServlet {
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	StudentDaoImp st = new StudentDaoImp();
	ArrayList<Student> list = null;
	list = st.getStudent();
	if(list!=null) {
		RequestDispatcher rd = req.getRequestDispatcher("view.jsp");
		req.setAttribute("li", list);
		rd.forward(req, resp);
	}else {
		RequestDispatcher rd = req.getRequestDispatcher("view.jsp");
		req.setAttribute("message", "No students found");
		rd.forward(req, resp);
	}
	
}
}
