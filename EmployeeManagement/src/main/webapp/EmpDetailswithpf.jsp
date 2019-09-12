<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page import="com.comakeit.ems.EmpBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DISPLAY EMPLOYEE WITH PF</title>

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
				<th>PF</th>
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
				<td><%=(b.getSalary() / 100) * 5%></td>
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