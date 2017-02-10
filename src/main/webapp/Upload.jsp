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
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div>
					<img alt="img" class="centered margin"
						src="data:image/jpeg;base64,${sessionScope.reimbursement.receipt}" />
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form action="uploadFile" method="post"
					enctype="multipart/form-data">
					<div><input type="text" name="rid"
						value="${sessionScope.reimbursement.id }" class="hidden" /> <input
						type="file" name="file" /> <input type="submit" value="upload" /></div>
				</form>
				<a href="EmpReimbursement.jsp" class="btn">Back</a>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</body>
</html>