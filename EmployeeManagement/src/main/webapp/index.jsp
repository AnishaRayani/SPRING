<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<script>
	function validate() {
		var username = document.form.username.value;
		var password = document.form.password.value;

		if (username == null || username == "") {
			alert("Username cannot be blank");
			return false;
		} else if (password == null || password == "") {
			alert("Password cannot be blank");
			return false;
		}
	}
</script>
<style>
body {
	 background-color:powderblue;
	}
	span
	{
	color: red;
	}
	div
	{
	text-align: center;
	}
	table {
	
  width: 80%;
}

	</style>
</head>
<body>
	<div>

		<div>
			<h2>
				WELCOME<br>
			</h2>
			<h1>EMPLOYEE MANAGEMENT</h1>
		</div>
	</div>

	<br>
	<form name="form" action="/validate" method="post"
		onsubmit="return validate()">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><span><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage") %></span></td>

			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Login"></input><input
					type="reset" value="Reset"></input></td>
			</tr>
			<tr>
				<td><p>
					<h5>If you are a new user username is your name and password
						is your name+123 ->eg name:alice username:alice password:alice123</h5>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>