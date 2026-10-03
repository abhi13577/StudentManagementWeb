package com.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.studentapp.dao.StudentDaoImp;
import com.studentapp.dto.Student;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class Signup extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s = new Student();
		StudentDaoImp st = new StudentDaoImp();
		PrintWriter out = resp.getWriter();
		s.setSname(req.getParameter("name"));
		s.setEmail(req.getParameter("email"));
		s.setBranch(req.getParameter("branch"));
		s.setLocation(req.getParameter("loc"));
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		if(req.getParameter("password").equals(req.getParameter("confirm"))) {
			s.setPassword(req.getParameter("password"));
			if(st.insertStudent(s)) {
				out.print("Signup Sucessfully shishya");
				RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
				req.setAttribute("pass","Shihshya Signup sucessfull");
				rd.forward(req, resp);
			}else {
//				out.print("Guldu Signup failed");
				RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
				req.setAttribute("fail","Guldu Sinup failed");
				rd.forward(req, resp);
			}
		}else {
//			out.print("Password correct agi hako g@ldu");
			RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
			req.setAttribute("fail", "Password correct agi hako g@ndu");
			rd.forward(req, resp);
		}
	}

}
