<%@page import="com.comakeit.ems.bean.LeaveBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>APPLY LEAVE</title>
<style>
body {
	background-color: powderblue;
}

span {
	color: red;
}

div {
	text-align: center;
}
</style>
<script>
	function validate() {
		
		var startdate = document.form.startdate.value;
		var enddate = document.form.enddate.value;
		var reason = document.form.reason.value;
		
		if (startdate == null || startdate == "") {
			
			alert("startdate cannot be blank");
			return false;
			
		} else if (enddate == null || enddate == "") {
			
			alert("enddate cannot be blank");
			return false;
			
		} else if (reason == null || reason == "") {
			
			alert("Email cannot be blank");
			return false;
			
		}
	}
</script>
</head>
<body>
	<div>
		<%
				String name = (String) session.getAttribute("name");
			%>
		<form name="form" action="/empleave" method="POST"
			onsubmit="return validate()">
			<table>
				<tr>
					<td>EmpName:</td>
					<td><button id="b1"><%=name%></button></td>
				</tr>
				<tr>
					<td>StartDate:</td>
					<td><input type="text" name="startdate" /><br> <br></td>
				</tr>
				<tr>
					<td>EndDate:</td>
					<td><input type="text" name="enddate" /><br> <br></td>
				</tr>
				<tr>
					<td>Reason:</td>
					<td><input type="text" name="reason" /><br> <br></td>
				</tr>
				<tr>
					<td><span><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%>
					</span></td>
				</tr>
				<tr>

					<td><input type="submit" value="submit" name="submit"></input><input
						type="reset" value="Reset"></input></td>
				</tr>
			</table>


			<br> <br> <a href=/logout>LOGOUT</a><br>

		</form>

	</div>

</body>
</html>