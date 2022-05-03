<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment booked successfully</title>
</head>
<body>
	
	<h3>
		Appointment Details
	</h3>
	<label>Appointment ID: </label>
	<span>
		"${Appointment.appoint_id}",
	</span> 
	<label>Doctor ID: </label>
	<span>
		"${Appointment.doctor_id}",
	</span>
	<label>Appointment Day: </label> 
	<span>
		"${Appointment.day}",
	</span> 
	<label>Appointment start time: </label>
	<span>
		"${Appointment.start_time}",
	</span> 
	<label>Appointment end time: </label>
	<span>
		"${Appointment.end_time}"
	</span> 
	<br>
	<br>
	<span> Your appointment was booked successfully!!</span> <br>
	<p> See You soon! </p> <br></br>
	<a href="loginPatientRedirect" > BACK TO LOGIN </a>
</body>
</html>