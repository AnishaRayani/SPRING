
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME MANAGER</title>

</head>
<body bgcolor="#EDBB99">
	<div style="text-align: center">
		<h3>WELCOME MANAGER</h3>
		<a href="ApplyEmpLeave.jsp">1).APPLY FOR LEAVE</a><br> <br>
		<a href=/checkstatus>2).CHECK STATUS FOR LEAVE</a><br> <br>
		<a href=/grantleave?varname=grantleave>3).GRANT PERMISSION FOR
			LEAVE</a><br> <br> <br> <span style="color: red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
		<br>
		<br>
		<a href=/logout>LOGOUT</a><br> <br>
	</div>
</body>
</html>