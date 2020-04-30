<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.sql.*"%>
        <%
        	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
			response.setHeader("Pragma", "no-cache"); //HTTP 1.0
			response.setHeader("Expires", "0"); //Proxies
            String url="jdbc:mysql://localhost:3306/project";
            String userName="root";
            String password="Qwertyup123";
            try{
                Class.forName("com.mysql.jdbc.Driver");
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        %>
        <h2 align="center"><font><strong>Available Course List</strong></font></h2>
        <table align="center" cellpadding="15" cellspacing="15" border="1">
            <tr>
                <td><b>Course ID</b></td>
                <td><b>Course Name</b></td>
                <td><b>Lecturer</b></td>
            </tr>
            <%
            try{
                Connection con=DriverManager.getConnection(url,userName,password);
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("SELECT * FROM course");             
                while(rs.next()){
            %>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
            </tr>
                <%
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            %>
</body>
</html>