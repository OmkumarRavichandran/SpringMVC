<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Doctor</title>
</head>
<body>
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="getdoctor">
				<div>
					<label for="doctor_id">Doctor id</label>
					<div>
						<form:input path="doctor_id" />
					</div>
				</div>
				<div>
					<label for="doctor_name">First Name</label>
					<div>
						<form:input path="doctor_name" />
					</div>
				</div>
				<div>
					<label for="dob">Last Name</label>
					<div>
						<form:input path="dob" />
					</div>
				</div>
				<div>
					<label for="speciality">Email</label>
					<div>
						<form:input path="speciality" />
					</div>
				</div>
				<div>
					<label for="city">Hire Date</label>
					<div>
						<form:input path="city" />
					</div>
				</div>
				<div>
					<label for="phone_no">Job Id</label>
					<div>
						<form:input path="phone_no" />
					</div>
				</div>
				<div>
					<label for="standard_fees">Salary</label>
					<div>
						<form:input path="standard_fees" />
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>