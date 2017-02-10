<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="resources/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee View</title>
</head>
<body>
	<div class="header">
		<ul class="nav nav-tabs nav-justified">
			<li role="presentation" class=""><a href="ManReimbursement.jsp">Reimbursements</a></li>
			<li role="presentation" class="active"><a href="ManEmpView.jsp">Employee
					Viewer</a></li>
			<li role="presentation" class=""><a href="logout">Logout</a></li>
		</ul>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="jumbotron margin">
					<h2 class="centered">Employees</h2>
					<table id="empTable">
						<thead>
							<tr>
								<th>Username</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
							</tr>
						</thead>
						<tbody id="empTableBody">
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
	<script src="resources/js/populateEmpTable.js" type="text/javascript"></script>
</body>
</html>