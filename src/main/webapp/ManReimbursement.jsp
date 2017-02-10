<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="resources/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reimbursements</title>
</head>
<body>
	<div class="header">
		<ul class="nav nav-tabs nav-justified">
			<li role="presentation" class="active"><a
				href="ManReimbursement.jsp">Reimbursements</a></li>
			<li role="presentation" class=""><a href="ManEmpView.jsp">Employee
					Viewer</a></li>
			<li role="presentation" class=""><a href="logout">Logout</a></li>
		</ul>
	</div>

	<div class="container-fluid">

		<div class="row">
			<div class="col-md-12">
				<h2 class="centered">Reimbursements</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron margin">
					<table id="reimTable">
						<thead>
							<tr>
								<th class="hidden">ID</th>
								<th>Author</th>
								<th>Amount</th>
								<th>Description</th>
								<th>Receipt</th>
								<th>Submitted</th>
								<th>Resolved</th>
								<th>Resolver</th>
								<th>Status</th>
								<th>Type</th>
								<th>Resolve Request</th>
							</tr>
						</thead>
						<tbody id="reimTableBody">
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
			<div class="jumbotron">
				<h4 class="centered">View Requests</h4>
				<form id="reimViewForm" class="form-horizontal" method="post">

					<div class="form-group">
						<label class="control-label" for="username">Author</label> <input
							type="text" class="form-control" id="username" name="username"
							placeholder="Employee Username">
					</div>
					<div class="form-group">
						<label class="control-label" for="reso">Resolved By</label> <input
							type="text" class="form-control" id="reso"
							placeholder="Manager Username" name="reso"></input>
					</div>
					<div class="form-group">
						<label for="stat">Status</label> <select class="form-control"
							id="stat" name="stat">
							<option>Pending</option>
							<option>Approved</option>
							<option>Denied</option>
							<option>All</option>
						</select>
					</div>
					<button type="submit" class="btn btn-primary"
						id="filterButt">Filter Results</button>
				</form>
			</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<div id="currentUser" class="hidden">${user.uname}</div>
	<div id="test"></div>
	<div class="hidden">
		<form id="viewForm" action="viewRec" method="post" target="_blank">
			<input type="text" id="recId" name="recId" />
		</form>
	</div>



	<script src="resources/js/populateManTable.js" type="text/javascript"></script>
</body>
</html>