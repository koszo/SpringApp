<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update region</title>
</head>
<body>
	<br>
	<h1>Update existing region</h1>


	<br />


	<form method="post"
		action="${pageContext.request.contextPath}/region/update">
		<input type="text" value="${region.getRegionName()}" name="regionName">
		<input type="hidden" value="${region.getRegionId()}" name="regionId">
		<input type="submit" value="Update">
	</form>





</body>
</html>