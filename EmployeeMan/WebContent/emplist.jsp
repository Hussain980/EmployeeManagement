
<%@page import="com.pojo.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List of Employees</h1>
	<%
		List<Emp> el = (List<Emp>) session.getAttribute("elist");
	%>

	<table border="1" cellpadding="10" cellspacing="10">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Password</th>
			<th>Email</th>
			<th>Country</th>
			<th colspan="2">Action</th>
		</tr>
		<%
			for (Emp e : el) {
		%>
		<tr>
			<td><%=e.getId()%></td>
			<td><%=e.getName()%></td>
			<td><%=e.getPassword()%></td>
			<td><%=e.getEmail()%></td>
			<td><%=e.getCountry()%></td>
			<td><a href="EmpServlet?action=edit&id=<%=e.getId()%>">Edit</a></td>
			<td><a href="EmpServlet?action=delete&id=<%=e.getId()%>">Delete</a>
			</td>
			
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>