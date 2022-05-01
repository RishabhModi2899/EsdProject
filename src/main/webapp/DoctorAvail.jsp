<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Availability</title>
</head>
<body>
	<p> Please enter your availability </p>
	<form action="/onSubmitAvail" method="post">
		<label>Week Start Date</label>
		<input type="date" name="week_start_date" />
	 	
	 	<label>SSN</label>
		<input type="number" name="ssn" /> <br></br>
	 	
		<label>Monday:</label> <br></br>
		<input type="time" name="m_start_time" min="09:00" max="18:00" required>
		<input type="time" name="m_end_time" min="09:00" max="18:00" required> <br></br>
		
		<label>Tuesday</label> <br></br>
		<input type="time" name="t_start_time" min="09:00" max="18:00" required>
		<input type="time" name="t_end_time" min="09:00" max="18:00" required> <br></br>
		
		<label>Wednesday</label> <br></br>
		<input type="time" name="w_start_time" min="09:00" max="18:00" required>
		<input type="time" name="w_end_time" min="09:00" max="18:00" required> <br></br>
		
		<label>Thursday</label> <br></br>
		<input type="time" name="th_start_time" min="09:00" max="18:00" required>
		<input type="time" name="th_end_time" min="09:00" max="18:00" required> <br></br>
		
		<label>Friday</label> <br></br>
		<input type="time" name="f_start_time" min="09:00" max="18:00" required>
		<input type="time" name="f_end_time" min="09:00" max="18:00" required> <br></br>
		
		<label>Number of patients you want to treat: </label>
		<input name="count" type="number" />  <br></br>
		
		<input type="submit" value="ADD">
	</form>
</body>
</html>