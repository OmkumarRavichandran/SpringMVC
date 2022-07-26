<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<div id="root">
		<div id="form">
			<form:form action="add" method="post" modelAttribute="addemployee">
				<div>
					<label for="empId">Employee id</label>
					<div>
						<form:input path="empId" />
					</div>
				</div>
				<div>
					<label for="first_name">First Name</label>
					<div>
						<form:input path="first_name" />
					</div>
				</div>
				<div>
					<label for="last_name">Last Name</label>
					<div>
						<form:input path="last_name" />
					</div>
				</div>
				<div>
					<label for="email">Email</label>
					<div>
						<form:input path="email" />
					</div>
				</div>
				<div>
					<label for="hireDate">Hire Date</label>
					<div>
						<form:input path="hireDate" />
					</div>
				</div>
				<div>
					<label for="jobId">Job Id</label>
					<div>
						<form:input path="jobId" />
					</div>
				</div>
				<div>
					<label for="salary">Salary</label>
					<div>
						<form:input path="salary" />
					</div>
				</div>
				<div>
					<form:button>Add New</form:button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>