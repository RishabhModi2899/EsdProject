<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book an Appointment</title>
</head>
<body>
	<p>Appointment Booking</p>
	<div style="display:flex;">
		<div id="tableContainer">
			<table border = 1>
		<c:forEach items="${AvailableDoctors}" var="vars">
	    <tr>
	    	<td style="color:blue">Week Start Date</td> 
	    	<td style="color:blue">"${vars.week_start_date}" </td>
	    	<td style="color:blue">Doctor Id</td>
	    	<td style="color:blue">"${vars.doctor_id}"</td>
	    </tr>
	    <tr>
	        <td>Monday Start Time: </td>
	        <td> <c:out value="${vars.monday_sd}"> </c:out></td>
	        <td>Monday End Time: </td>
	        <td> <c:out value="${vars.monday_ed}"> </c:out></td>
	   	</tr>
	   	<tr>
	        <td>Tuesday Start Time: </td>
	        <td> <c:out value="${vars.tuesday_sd}"> </c:out></td>    
	        <td>Tuesday End Time: </td>
	        <td> <c:out value="${vars.tuesday_ed}"> </c:out></td>
	   	</tr>
	   	<tr>
	        <td>Wednesday Start Time: </td>
	        <td><c:out value="${vars.wednesday_sd}"> </c:out></td>
	        <td>Wednesday End Time: </td>
	        <td><c:out value="${vars.wednesday_sd}"> </c:out></td>
	    </tr>
	    <tr>
	        <td>Thursday Start Time: </td>
	        <td><c:out value="${vars.thursday_sd}"> </c:out></td>
	        <td>Thursday End Time: </td>
	        <td><c:out value="${vars.thursday_ed}" > </c:out></td>
	   	</tr>
	   	<tr>
	        <td>Friday Start Time: </td>
	        <td><c:out value="${vars.friday_sd}" > </c:out></td>
	        <td>Friday End Time: </td>
	        <td><c:out value="${vars.friday_ed}" > </c:out></td>
	    </tr>
	    </c:forEach>
    </table>
		</div>
		
		<div id="container2" style="margin-left:5%">
			<form action = "/bookAppointment" method="post">
				<p>
					Appointment Information
				</p>
				<label>
					Please Enter the doctor Id of the Doctor you wish to consult?
				</label>
				<input type="number" name="doc_id" required/><br></br>
				
				<label>
					Enter the day you wish to visit?
				</label>
				<input type="text" name="Day" required/><br></br>
				
				<input type = "submit" value = "Book Slot" />
			</form>
		</div>
		
	</div>
</body>
</html>