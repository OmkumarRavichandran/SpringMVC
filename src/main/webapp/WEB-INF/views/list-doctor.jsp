<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor List</title>
</head>
<body>
	<div id="table root">
		<table>
			<thead>
				<tr>
					<th>Doctor Id</th>
					<th>Doctor Name</th>
					<th>Dob</th>
					<th>Speciality</th>
					<th>City</th>
					<th>Phone no</th>
					<th>Standard Fees</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="doc" items="${alldoctor}">
					<tr>
						<td>${doc.doctor_id}</td>
						<td>${doc.doctor_name}</td>
						<td>${doc.dob}</td>
						<td>${doc.speciality}</td>
						<td>${doc.city}</td>
						<td>${doc.phone_no}</td>
						<td>${doc.standard_fees}</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>