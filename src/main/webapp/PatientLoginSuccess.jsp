<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Login Success</title>
</head>
<body>
	<p>
		Logged in successfully! <br></br>
		Welcome ${PatientModel.firstName}, <br></br>
	</p> <br></br>
	<a href = "/viewAppointment"> MAKE AN APPOINTMENT </a> | 
	<a href = "bookedAppointments"> VIEW YOUR APPOINTMENT </a>
</body>
</html>