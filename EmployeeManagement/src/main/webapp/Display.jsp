<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page import="com.comakeit.ems.bean.EmpBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DISPLAY</title>
</head>
<link rel="stylesheet" type="text/css" href="Style.css">
<body>
	<div>

		<table>
			<tr>
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Email</th>
				<th>Department Name</th>
				<th>Reporting Manager</th>
				<th>Salary</th>
			</tr>
			<%
				List<EmpBean> list = (List<EmpBean>) request.getAttribute("object");
			%>
			<%
				for (EmpBean b : list) {
			%>
			<tr>
				<td><%=b.getEmpid()%></td>
				<td><%=b.getEmpname()%></td>
				<td><%=b.getEmail()%></td>
				<td><%=b.getDepartmentname()%></td>
				<td><%=b.getReportingmanager()%></td>
				<td><%=b.getSalary()%></td>
			</tr>
			<%
				}
			%>


		</table>
		<br> <br> <a href="AdminOptions.jsp">GO BACK TO OPTIONS</a><br>
		<br> <a href=/logout>LOGOUT</a>
	</div>
</body>

</html>