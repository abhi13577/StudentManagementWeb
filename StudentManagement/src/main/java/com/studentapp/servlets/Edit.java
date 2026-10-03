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
import jakarta.servlet.http.HttpSession;

@WebServlet("/edit")
public class Edit extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(false); 
		Student s = (Student) session.getAttribute("student");
		s.setSname(req.getParameter("name"));
		s.setBranch(req.getParameter("branch"));
		s.setLocation(req.getParameter("location"));
		StudentDaoImp st = new StudentDaoImp();
		if(st.updateStudent(s)) {
			RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
			req.setAttribute("message", "Update Successfully");
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
			req.setAttribute("message", "Update failed");
			rd.forward(req, resp);
		}
	}
}
