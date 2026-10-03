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
import jakarta.servlet.http.HttpSession;

@WebServlet("/logphone")
public class Logph extends  HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student s = null;
		StudentDaoImp st = new StudentDaoImp();
		PrintWriter out = resp.getWriter();
		long phone = Long.parseLong(req.getParameter("phone"));
		String password = req.getParameter("password");
		HttpSession session = req.getSession(true);
		s = st.getStudent(phone, password);
		if(s!=null) {
			RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
//			req.setAttribute("student", s);
//			req.setAttribute("message", "Login Sucessfull");
			session.setAttribute("student",s);
			session.setAttribute("message", "Login sucessfull");
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd2 = req.getRequestDispatcher("logph.jsp");
//			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			req.setAttribute("fail", "Login failed");
//			session.setAttribute("fail", "login failed");
			rd2.forward(req, resp);
	}

}
}
