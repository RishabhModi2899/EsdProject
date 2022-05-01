<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" 
    xmlns:th="http://www.thymeleaf.org" 
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
<meta charset="ISO-8859-1">
<title>HMS</title>
</head>
<body>
	<div style="display: flex; flex-direction: column; justify-content: center; align-items: center">
		<h1>
			HMS
		</h1>
		<br></br>
		<form action="/redirectUser" method="post">
			<p>What are you?</p>
			<input type="radio" id="patient" name="association" value="patient">
			<label for="patient">PATIENT</label>
			<input type="radio" id="doctor" name="association" value="doctor">
			<label for="doctor">DOCTOR</label><br><br>
			<p>What do you want to do?</p>
			<input type="radio" id="patient" name="action" value="login">
			<label for="patient">LOGIN</label>
			<input type="radio" id="doctor" name="action" value="signup">
			<label for="doctor">SIGNUP</label><br><br>
			<input type="submit" value="SUBMIT">
		</form>
	</div>
</body>
</html>