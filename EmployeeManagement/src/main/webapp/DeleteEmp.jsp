<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DELETE EMPLOYEE</title>
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

		var empid = document.form.empid.value;

		if (empid == null || empid == "") {

			alert("EMPID cannot be blank");
			return false;

		}
	}
</script>
</head>
<body>
	<form name="form" action="/delete" method="POST"
		onsubmit="return validate()">
		Empid:<input type="text" name="empid"><br> <br> <br>
		<span><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
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