<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setHeader("Expires", "0"); //Proxies
	if(session.getAttribute("uname")==null){
		response.sendRedirect("Login.jsp");
	}
%>
<form action="Register" method="post">
	Name:<input type="text" name="name"><br>
	Mail Id:<input type="text" name="mail"><br>
	Phone No:<input type="text" name="phone"><br>
	Course Id:<input type="text" name="courseId"><br>
	<input type="submit" value="Register"> 
</form>
<form action="List.jsp">
	<input type="submit" value="Available Course">
</form>
<form action="Logout" method="post">
	<input type="submit" value="Logout">
</form>
</body>
</html>