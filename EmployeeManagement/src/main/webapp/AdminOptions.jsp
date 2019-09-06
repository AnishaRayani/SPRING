<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN OPTIONS</title>
</head>
<link rel="stylesheet" type="text/css" href="Style.css">
<body>
	<div>
		<a href="AddEmp.jsp">1).ADD EMPLOYEE</a><br> <br> <br>
		<a href="DeleteEmp.jsp">2).DELETE EMPLOYEE</a><br> <br> <br>
		<a href="/listempbyid">3).VIEW LIST ORDERBY EMPID</a><br> <br>
		<br> <a href="/listempbydepart">4).VIEW LIST ORDERBY
			DEPARTMENT</a><br> <br> <br> <a href="EmpReport.jsp">5).VIEW
			LIST OF EMPLOYEE REPORTING UNDER A PARTICULAR MANAGER</a><br> <br>
		<br> <a href="/listwithpf">6).VIEW THE LIST WITH PF</a><br>
		<br> <br> <a href="/listwithrange">7).VIEW LIST OF
			EMPLOYEE WHOSE SALARY RANGES FROM 10000 to 20000</a><br> <br> <br>
		<br> <br> <br> <a href=/logout>LOGOUT</a>
	</div>
</body>
</html>
