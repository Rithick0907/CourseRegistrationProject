package com.studentCourseRegistration;
import java.sql.*;
public class LoginCredentials {
	public boolean checkCredentials(String user,String pass) throws ClassNotFoundException, SQLException {
		boolean result=false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project","root","Qwertyup123");
		PreparedStatement st=con.prepareStatement("Select * From login where uname=? and password=?");
		st.setString(1, user);
		st.setString(2, pass);
		ResultSet rs=st.executeQuery();
		if(rs.next())	
		{
			result=true;
		}
		st.close();
		con.close();
		return result;
	}
}