package com.studentCourseRegistration;

import javax.servlet.http.*;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Logout")
public class Logout extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("Login.jsp");
	}

}