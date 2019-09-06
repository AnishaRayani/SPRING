<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIEW EMPLOYEE UNDER PARTICULAR REPORTING MANAGER</title>
<script>
	function validate() {

		var reportingmanager = document.form.reportingmanager.value;

		if (reportingmanager == null || reportingmanager == "") {

			alert("ReportingManager cannot be blank");
			return false;

		}
	}
</script>
</head>
<link rel="stylesheet" type="text/css" href="Style.css">
<body>
	<form name="form" action="/listempbyreport?varname=employeereporting"
		method="POST" onsubmit="return validate()">
		ReportingManager:<input type="text" name="reportingmanager"><br>
		<br> <br> <span><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
		<input type="submit" value="submit" name="submit">
	</form>
	<br>
	<br>
	<a href="AdminOptions.jsp">GO BACK TO OPTIONS</a>
	<br>
	<br>
	<a href=/logout>LOGOUT</a>
	<br>
	<br>
</body>
</html>