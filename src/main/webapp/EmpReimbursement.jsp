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
		<li role="presentation" class=""><a href="#">Home</a></li>
		<li role="presentation" class="active"><a href="EmpReimbursement.jsp">Reimbursements</a></li>
		<li role="presentation" class="disabled"><a href="#">Personal Information</a></li>
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
			<table data-toggle="table" id="reimTable">
				<thead>
					<tr>
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
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h4 class="centered">Create new reimbursement request</h4>
				<form class="form-horizontal" action="makeReq" method="post">
					<div class="form-group">
						<label class="control-label" for="amount">Amount</label> <input
							type="number" step="0.01" class="form-control" id="amount"
							placeholder="0.00" name="amount" required>
					</div>
					<div class="form-group">
						<label class="control-label" for="desc">Description</label>
						<textarea class="form-control" id="desc" placeholder="Description"
							name="desc" required></textarea>
					</div>
					<div class="form-group">
						<label for="reason">Select list:</label> <select
							class="form-control" id="reason" name="reason" required>
							<option>Travel</option>
							<option>Certification</option>
							<option>Other</option>
						</select>
					</div>
					<button type="submit" class="btn btn-default margin">Create
						Reimbursement Request</button>
				</form>
				<c:if test="${reqSuccess != null }">
					<div class="panel panel-success margin">
						<div class="panel-heading">Success</div>
						<div class="panel-body">Reimbursement request was submitted
							successfully</div>
					</div>
				</c:if>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>



<script src="resources/js/populateTable.js" type="text/javascript" ></script>
</body>
</html>