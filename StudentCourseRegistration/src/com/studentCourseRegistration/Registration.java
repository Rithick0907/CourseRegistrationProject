package com.studentCourseRegistration;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/Register")
public class Registration extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		String name=request.getParameter("name");
		String mail=request.getParameter("mail");
		String phone=request.getParameter("phone");
		String courseId=request.getParameter("courseId");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project","root","Qwertyup123");
			PreparedStatement ps=con.prepareStatement("INSERT INTO user_entry VALUES (?,?,?,?)");
			ps.setNString(1, name);
			ps.setNString(2, mail);
			ps.setNString(3, phone);
			ps.setNString(4, courseId);
			int count=ps.executeUpdate();
			ps.close();
			con.close();
			response.sendRedirect("CourseList.jsp");
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}		
	}
}