<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor logged In successfully</title>
</head>
<body>
	Logged In successfully!!! <br></br>
	Welcome back, ${DoctorModel.firstName} <br></br>
	<a href="doctorAddAvailability"> Add your availability </a>
</body>
</html>