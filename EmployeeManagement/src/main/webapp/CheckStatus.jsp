<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page import="com.comakeit.ems.LeaveBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check Status</title>
</head>
<link rel="stylesheet" type="text/css" href="Style.css">
<body>
	<div>

		<table>
			<tr>
				<th>LEAVE ID</th>
				<th>Employee Name</th>
				<th>STARTDATE</th>
				<th>ENDDATE</th>
				<th>REASON</th>
				<th>STATUS</th>
			</tr>
			<%
				List<LeaveBean> list = (List<LeaveBean>) request.getAttribute("object");
			%>
			<%
				for (LeaveBean b : list) {
			%>
			<tr>
				<td><%=b.getLeaveid()%></td>
				<td><%=b.getEmpname()%></td>
				<td><%=b.getStartdate()%></td>
				<td><%=b.getEnddate()%></td>
				<td><%=b.getReason()%></td>
				<td><%=b.getStatus()%></td>
			</tr>
			<%
				}
			%>


		</table>
		<br> <br> <a href=/logout>LOGOUT</a> <br>
	</div>
</body>

</html>