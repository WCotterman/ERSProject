<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="resources/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Info</title>
</head>
<body>
	<div class="header">
		<ul class="nav nav-tabs nav-justified">
			<li role="presentation" class=""><a href="EmpReimbursement.jsp">Reimbursements</a></li>
			<li role="presentation" class="active"><a
				href="EmployeeInfo.jsp">Personal Information</a></li>
			<li role="presentation" class=""><a href="logout">Logout</a></li>
		</ul>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8 jumbotron margin">
				<h1 class="centered">Personal Information</h1>
				<table class="table margin">
				<tr><td class="lead ">Username: </td><td class="lead ">${user.uname}</td></tr>
				<tr><td class="lead ">First Name:</td><td class="lead ">${user.fname}</td></tr>
				<tr><td class="lead ">Last Name:</td><td class="lead ">${user.lname}</td></tr>
				<tr><td class="lead ">Email Address:</td><td class="lead ">${user.email}</td></tr>
				<tr><td class="lead ">Role:</td><td class="lead ">${user.role}</td></tr>
				</table>
			</div>
			<div class="col-md-2"></div>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h2 class="centered">Update Info</h2>
				<form action="update" method="post" id="updateForm" class="form-horizontal margin">
					<div class="form-group hidden">
						<label class="control-label" for="username">Username</label> <input
							type="text" class="form-control" id="username" name="username"
							value="${user.uname}" readonly>
					</div>
					<div class="form-group">
						<label for="fname">First Name</label> <input type="text"
							class="form-control" id="fname" value="${user.fname}"
							name="fname">
					</div>
					<div class="form-group">
						<label for="lname">Last Name</label> <input type="text"
							class="form-control" id="lname" value="${user.lname}"
							name="lname">
					</div>
					<div class="form-group">
						<label for="email">Email Address</label> <input type="text"
							class="form-control" id="email" value="${user.email}" name="email">
					</div>
					<button type="submit" class="btn btn-primary btn-block" id="updateButt">Update</button>
				</form>
				<div id="updated" style="display: none">
					<div class="panel panel-success margin">
						<div class="panel-heading">Success</div>
						<div class="panel-body">Your contact information was
							successfully updated</div>
					</div>
				</div>
				<div id="updateFail" style="display: none">
					<div class="panel panel-error margin">
						<div class="panel-heading">Error</div>
						<div class="panel-body">Your contact information could not be updated</div>
					</div>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<script src="resources/js/updateInfo.js" type="text/javascript"></script>
</body>
</html>