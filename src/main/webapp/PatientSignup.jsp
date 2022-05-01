<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Sign Up</title>
<link rel="stylesheet" href="PatientSignupStyles.css">
</head>
<body>
	<form action="/registerPatient" method="post" id="patientSignupForm">
		<div class="container">
			<label>
				PATIENT SIGN UP
			</label>
		</div>
		<br></br>
		<div class="docContainer">
			<span>
				<c:forEach items="${Errors}" var = "error">
					<p> Error: "${error}" </p> <br></br>
				</c:forEach>
			</span>
		</div>
		<div class="container">
			<label>FIRST NAME</label>
			<input name="firstname" type="text" />
		</div>
		<br></br>
		<div class="container">
			<label>LAST NAME</label>
			<input name="lastname" type="text" />
		</div>
		<br></br>
		<div class="container">
			<label>AGE</label>
			<input name="age" type="number" />
		</div>
		<br></br>
		<div class="container">
			<label>SSN</label>
			<input name="ssn" type="number" />
		</div>
		<br></br>
		<div class="container">
			<label>INSURANCE POLICY #</label>
			<input name="insurance" type="number" />
		</div>
		<br></br>
		<div class="container">
			<label>USERNAME</label>
			<input name="username" type="email" />
		</div>
		<br></br>
		<div class="container">
			<label>PASSWORD</label>
			<input name="password" type="password" />
		</div>
		<br></br>
		<div class="container">
			<label>ADDRESS LINE 1</label>
			<input name="address1" type="text" />
		</div>
		<br></br>
		<div class="container">
			<label>ADDRESS LINE 2</label>
			<input name="address2" type="text" />
		</div>
		<br></br>
		<div class="container">
			<label>CITY</label>
			<input name="city" type="text" />
		</div>
		<br></br>
		<div class="container">
			<label>ZIP CODE	</label>
			<input name="zip" type="number" />
		</div>
		<br></br>
		<div class="container">
			<label>STATE</label>
			<input name="state" type="text" />
		</div>
		<br></br>
		<div class="container">
			<label>COUNTRY</label>
			<input name="country" type="text" />
		</div>
		<br></br>
		<div class="container">
			<input type="submit" value="SIGNUP"/>
		</div>
	</form>
</body>
</html>