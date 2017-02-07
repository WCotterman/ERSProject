<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="resources/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h1 class="centered">Title</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="jumbotron">
					<form action="login" method="post">
						<div class="form-group">
							<label for="username">Username</label> <input type="text"
								class="form-control" id="username" placeholder="Username"
								name="uname">
						</div>
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" id="password" placeholder="Password"
								name="pass">
						</div>
						<button type="submit" class="btn btn-default">Login</button>
						<c:if test="${not empty error }">
							<div class="panel panel-danger margin">
								<div class="panel-heading">Error</div>
								<div class="panel-body">${error }</div>
							</div>
						</c:if>
					</form>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4"></div>
			<div class="col-md-4"></div>
		</div>
	</div>



</body>
</html>