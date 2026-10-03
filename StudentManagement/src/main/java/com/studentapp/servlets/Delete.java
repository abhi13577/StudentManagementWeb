package com.studentapp.servlets;

import java.io.IOException;

import com.studentapp.dao.StudentDaoImp;
import com.studentapp.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class Delete extends HttpServlet{
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	Student s = new Student();
	s.setSid(Integer.parseInt(req.getParameter("sid")));
	StudentDaoImp st = new StudentDaoImp();
	if(st.deleteStudent(s)) {
//		RequestDispatcher rd = req.getRequestDispatcher("view.jsp");
//		req.setAttribute("message", "Student profile deleted Sucessfully");
		resp.sendRedirect("viewStudents?message=Deleted Successfull");
		
	}else {
		RequestDispatcher rd = req.getRequestDispatcher("view.jsp");
		req.setAttribute("message", "Delete operation failed");
		rd.forward(req, resp);
	}
}
}
