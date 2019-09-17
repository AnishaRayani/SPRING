<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Style.css">
<title>WELCOME MANAGER</title>
</head>
<body>
	<div>
		<h3>WELCOME MANAGER</h3>
		<a href="ApplyEmpLeave.jsp">1).APPLY FOR LEAVE</a><br> <br>
		<a href=/checkstatus>2).CHECK STATUS FOR LEAVE</a><br> <br>
		<a href=/grantleave>3).GRANT PERMISSION FOR
			LEAVE</a><br> <br> <br> <span><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%>
		</span> <br> <br> <a href=/logout>LOGOUT</a><br> <br>
	</div>
</body>
</html>