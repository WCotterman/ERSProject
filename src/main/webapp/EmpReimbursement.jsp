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
				href="EmpReimbursement.jsp">Reimbursements</a></li>
			<li role="presentation" class=""><a href="EmployeeInfo.jsp">Personal
					Information</a></li>
			<li role="presentation" class=""><a href="logout">Logout</a></li>
		</ul>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="jumbotron margin">
					<h2 class="centered">Reimbursements</h2>
					<table id="reimTable">
						<thead>
							<tr>
								<th>ID</th>
								<th>Author</th>
								<th>Amount</th>
								<th>Description</th>
								<th>Receipt</th>
								<th>Submitted</th>
								<th>Resolved</th>
								<th>Resolver</th>
								<th>Status</th>
								<th>Type</th>
							</tr>
						</thead>
						<tbody id="reimTableBody">
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-5">
				<div class="jumbotron margin">
					<h4 class="centered">Create new reimbursement request</h4>
					<form id="reimForm" class="form-horizontal" action="makeReq"
						method="put">

						<div class="form-group hidden">
							<label class="control-label" for="username">Username</label> <input
								type="text" class="form-control" id="username" name="username"
								value="${user.uname}" readonly>
						</div>
						<div class="form-group">
							<label class="control-label" for="amount">Amount</label> <input
								type="number" step="0.01" class="form-control" id="amount"
								placeholder="0.00" name="amount" required>
						</div>
						<div class="form-group">
							<label class="control-label" for="desc">Description</label>
							<textarea class="form-control" id="desc"
								placeholder="Description" name="desc" required></textarea>
						</div>
						<div class="form-group">
							<label for="reason">Reason</label> <select class="form-control"
								id="reason" name="reason" required>
								<option>Travel</option>
								<option>Certification</option>
								<option>Other</option>
							</select>
						</div>
						<button type="submit" class="btn btn-primary"
							id="submitButt">Create Reimbursement Request</button>
					</form>
					<div id="success" style="display: none">
						<div class="panel panel-success margin">
							<div class="panel-heading">Success</div>
							<div class="panel-body">Reimbursement request was submitted
								successfully</div>
						</div>
					</div>
					<div id="fail" style="display: none">
						<div class="panel panel-error margin">
							<div class="panel-heading">Error</div>
							<div class="panel-body">Amount must be greater than 0</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-5">
				<div class="jumbotron margin">
					<h4 class="centered">Filter Requests</h4>
					<form id="reimFilterForm" class="form-horizontal" method="post">
						<div class="form-group">
							<label for="stat">Reimbursement Status</label> <select
								class="form-control" id="stat" name="stat">
								<option>Pending</option>
								<option>Approved</option>
								<option>Denied</option>
								<option>All</option>
							</select>
						</div>
						<button type="submit" class="btn btn-primary"
							id="filterEmpButt">Filter Results</button>
					</form>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
	<!-- Hidden tables for button params -->
	<div class="hidden">
		<form method="post" action="upload" id="upForm">
			<input type="text" id="upId" name="upId" />
		</form>
	</div>
	<div class="hidden">
		<form id="viewForm" action="viewRec" method="post" target="_blank">
			<input type="text" id="recId" name="recId" />
		</form>
	</div>

	<script src="resources/js/populateTable.js" type="text/javascript"></script>
</body>
</html>