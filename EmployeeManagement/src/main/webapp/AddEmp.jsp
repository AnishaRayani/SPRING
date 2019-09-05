<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD EMPLOYEE</title>
<script>
	function validate() {
		var empid = document.form.empid.value;
		var empname = document.form.empname.value;
		var email = document.form.email.value;
		var departmentname = document.form.departmentname.value;
		var reportingmanager = document.form.reportingmanager.value;
		var salary = document.form.salary.value;

		if (empid == null || empid == "") {
			alert("Empid cannot be blank");
			return false;
		} else if (empname == null || empname == "") {
			alert("EmpName cannot be blank");
			return false;
		}
		else if (email == null || email == "") {
			alert("Email cannot be blank");
			return false;
		}
		else if (departmentname == null || departmentname == "") {
			alert("DepartmentName cannot be blank");
			return false;
		}
		else if (reportingmanager == null || reportingmanager == "") {
			alert("ReportingManager cannot be blank");
			return false;
		}
		else if (salary == null || salary == "") {
			alert("Salary cannot be blank");
			return false;
		}
	}
</script>
<link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>

	<br>
	<form name="form" action="/add" method="post" onsubmit="return validate()">

		<div>
			<table>

				<tr>
					<td>Empid:</td>
					<td><input type="text" name="empid" /><br> <br></td>
				</tr>
				<tr>
					<td>EmpName:</td>
					<td><input type="text" name="empname" /><br> <br></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" /><br> <br></td>
				</tr>
				<tr>
					<td>DepartmentName:</td>
					<td><input type="text" name="departmentname" /><br> <br></td>
				</tr>
				<tr>
					<td>ReportingManager:</td>
					<td><input type="text" name="reportingmanager" /><br> <br></td>
				</tr>
				<tr>
					<td>Salary:</td>
					<td><input type="text" name="salary" /><br> <br></td>
				</tr>
				<tr>
					<td><span><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="submit" name="submit"></input><input
						type="reset" value="Reset"></input></td>
				</tr>


			</table>


			<br> <br> <a href="AdminOptions.jsp">GO BACK TO OPTIONS</a><br>
			<a href=/logout>LOGOUT</a>
		</div>
	</form>

</body>
</html>