<%@page import="com.pojo.Emp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
   Emp e = (Emp)session.getAttribute("e");
%>

	<form action="EmpServlet" method="post">
		<input type="hidden" name="action" value="updateEmp">

		<table border="1" cellpadding="10" cellspacing="10">
			<input type="hidden" name="id" value="<%= e.getId() %>">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="<%=e.getName()%>">
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="pass"
					value="<%=e.getPassword()%>">
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="<%=e.getEmail()%>">
			</tr>
			<tr>
				<td>Country</td>
				<td><input type="text" name="country"
					value="<%=e.getCountry()%>">
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="save"></td>
			</tr>


		</table>

	</form>

</body>
</html>