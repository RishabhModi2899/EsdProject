<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="DoctorLoginStyles.css">
<meta charset="ISO-8859-1">
<title>Doctor Log In</title>
</head>
<body>
	<form method="post" id="doctorLoginForm">
		<div class="containerDoc">
			<label>
				DOCTOR LOGIN
			</label>
		</div>
		<br></br>
		<div class="containerDoc">
			<label>USERNAME</label>
			<input name="username" type="email" />
		</div>
		<br></br>
		<div class="containerDoc">
			<label>PASSWORD</label>
			<input name="password" type="password" />
		</div>
		<br></br>
		<div class="containerDoc">
			<input type="submit" value="LOGIN"/>
		</div>
	</form>
</body>
</html>