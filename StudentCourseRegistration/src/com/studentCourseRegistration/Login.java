package com.studentCourseRegistration;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Login")
public class Login extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
		String uname=request.getParameter("uname");
		String password=request.getParameter("pass");
		LoginCredentials lc=new LoginCredentials();
		try {
			if(lc.checkCredentials(uname, password)) {
				HttpSession session=request.getSession();
				session.setAttribute("uname", uname);
				response.sendRedirect("CourseList.jsp");
			}
			else {
				response.sendRedirect("Login.jsp");
			}
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
