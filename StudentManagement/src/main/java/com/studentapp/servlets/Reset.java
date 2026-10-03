package com.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.studentapp.dao.StudentDaoImp;
import com.studentapp.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reset")
public class Reset extends HttpServlet{
         
	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student s = null;StudentDaoImp st = new StudentDaoImp();PrintWriter out = resp.getWriter();
		s = st.getStudent(req.getParameter("mail"), Long.parseLong(req.getParameter("phone")));
		RequestDispatcher rd = null;
		if(s!=null) {
			if(req.getParameter("pass").equals(req.getParameter("confirm"))) {
			    if(!s.getPassword().equals(req.getParameter("confirm"))) {
			    	s.setPassword(req.getParameter("confirm"));
			    	if(st.updateStudent(s)) {
//						out.print("Password updated Successfully");
						rd = req.getRequestDispatcher("login.jsp");
						req.setAttribute("message", "Password updated successfully");
					}else {
//						out.print("Something went wrong");
						rd = req.getRequestDispatcher("Reset.jsp");
						req.setAttribute("message", "Something went wrong");
					}
			    }else {
//			    	out.print("Password already Used");
			    	rd = req.getRequestDispatcher("Reset.jsp");
			    	req.setAttribute("message", "Password already used...!");
			    }
				
			}else {
//				out.print("Password Mismatch");
				rd = req.getRequestDispatcher("Reset.jsp");
				req.setAttribute("message", "Password mismatch...!");
			}
		}else {
//			out.print("Wrong Credentails");
			rd = req.getRequestDispatcher("Reset.jsp");
			req.setAttribute("message", "Wrong Credentails...!");
		}
		rd.forward(req, resp);
	}
}
