<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	<span style="color:red"> 
		${Error}
	</span>
	<br>
	<a href="loginPatientRedirect" > BACK TO LOGIN </a>
</body>
</html>