<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="PatientLoginStyles.css">
<meta charset="ISO-8859-1">
<title>Patient Login Page</title>
</head>
<body>
	<form method="post" id="patientLoginForm">
		<div class="wrapper">
			<label>
				PATIENT LOGIN
			</label>
		</div>
		<br></br>
		<div class="wrapper">
			<label>USERNAME</label>
			<input name="username" type="email" />
		</div>
		<br></br>
		<div class="wrapper">
			<label>PASSWORD</label>
			<input name="password" type="password" />
		</div>
		<br></br>
		<div class="wrapper">
			<input type="submit" value="LOGIN"/>
		</div>
	</form>
</body>
</html>