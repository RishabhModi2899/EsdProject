<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="DoctorSignupStyles.css">
<meta charset="ISO-8859-1">
<title>Doctor Sign Up Page</title>
</head>
<body>
	<form action="/registerDoctor" method="post" id="doctorSignupForm">

		<div class="docContainer">
			<label>
				DOCTOR SIGN UP
			</label>
		</div>
		<br></br>
		<div class="docContainer">
			<span>
				<c:forTokens items="${Errors}" delims = "," var = "error">
					Error: <c:out value="${error}" /> <br></br>
				</c:forTokens>
			</span>
		</div>
		<br></br>
		<div class="docContainer">
			<label>FIRST NAME</label>
			<input name="firstname" type="text"/>
		</div>
		<br></br>
		<div class="docContainer">
			<label>LAST NAME</label>
			<input name="lastname" type="text" />
		</div>
		<br></br>
		<div class="docContainer">
			<label>SSN</label>
			<input name="ssn" type="number" />
		</div>
		<br></br>
		<div class="docContainer">
			<label>Age</label>
			<input name="age" type="number" />
		</div>
		<br></br>
		<div class="docContainer">
			<label>USERNAME</label>
			<input name="username" type="email" />
		</div>
		<br></br>
		<div class="docContainer">
			<label>PASSWORD</label>
			<input name="password" type="password" />
		</div>
		<br></br>
		<div class="docContainer">
			<label>ADDRESS LINE 1</label>
			<input name="address1" type="text" />
		</div>
		<br></br>
		<div class="docContainer">
			<label>ADDRESS LINE 2</label>
			<input name="address2" type="text" />
		</div>
		<br></br>
		<div class="docContainer">
			<label>CITY</label>
			<input name="city" type="text" />
		</div>
		<br></br>
		<div class="docContainer">
			<label>STATE</label>
			<input name="state" type="text" />
		</div>
		<br></br>
		<div class="docContainer">
			<label>COUNTRY</label>
			<input name="country" type="text" />
		</div>
		<br></br>
		<div class="docContainer">
			<input type="submit" value="SIGNUP"/>
		</div>
	</form>
</body>
</html>