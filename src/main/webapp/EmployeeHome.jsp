<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="resources/header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="header">
	<ul class="nav nav-tabs nav-justified">
		<li role="presentation" class=""><a href="EmpReimbursement.jsp">Reimbursements</a></li>
		<li role="presentation" class=""><a href="EmployeeInfo.jsp">Personal Information</a></li>
		<li role="presentation" class=""><a href="logout">Logout</a></li>
	</ul>
</div>
<h1 class="centered">Employee Home</h1>

<c:out value="${sessionScope.user}"/>
</body>
</html>