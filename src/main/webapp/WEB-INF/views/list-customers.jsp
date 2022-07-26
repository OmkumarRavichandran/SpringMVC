<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>
	<div id="table root">
		<table>
			<thead>
				<tr>
					<th>Employee Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Hire Date</th>
					<th>Job Id</th>
					<th>Salary</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="emp" items="${allemployees}">
					<tr>
						<td>${emp.empId}</td>
						<td>${emp.first_name}</td>
						<td>${emp.last_name}</td>
						<td>${emp.email}</td>
						<td>${emp.hireDate}</td>
						<td>${emp.jobId}</td>
						<td>${emp.salary}</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>