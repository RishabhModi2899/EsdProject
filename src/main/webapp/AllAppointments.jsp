<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Your Appointments</title>
</head>
<body>
	<label>
		Your Appointments
	</label>
	<br>
	<div>
		<div style="display:flex">
			<table border=1>
				<c:forEach items="${BookedApp}" var="vars">
					<tr>
				    	<td> Appointment ID: </td> 
				    	<td> "${vars.appoint_id}" </td> 
				    </tr>
				    <tr>
				    	<td> Patient ID: </td> 
				    	<td> "${vars.patient_id}" </td> 
				    </tr>
				    <tr>
				    	<td> Patient First Name: </td> 
				        <td> "${vars.patient_first_name}"</td>
				    </tr>
				    <tr>
				        <td> Patient Last Name: </td>
				        <td> "${vars.patient_last_name}" </td>
				    </tr>
				    <tr>
				        <td> Doctor ID: </td>
				        <td> "${vars.doctor_id}" </td> 
				    </tr>
				    <tr>
				        <td> Day: </td> 
				        <td> "${vars.day}" </td>    
				     </tr>
				     <tr>
				        <td>Start Time: </td>
				        <td> "${vars.start_time}" </td>  
				     </tr>
				     <tr>
				        <td>End Time: </td>
				        <td>"${vars.end_time}" </td>  
				    </tr>
				    <br>
				</c:forEach>
			</table>
		</div>
		<div>
			<h3>Delete Appointment</h3>
			<form action="/deleteAppointment" method="post">
				<label>
					Enter Appointment ID:
				</label> 
				<input type="number" name="app_id" required />
				<br>
				<input type="submit" value="DELETE"/>
			</form>
		</div>
	</div>
	
	<br>
	<a href="/loginPatientRedirect"> BACK TO LOGIN </a>
</body>
</html>