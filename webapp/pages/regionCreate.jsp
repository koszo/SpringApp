<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>region create</title>
</head>
<body>

<h1>Add Region</h1>

<br/>
	<form method="post" action="${pageContext.request.contextPath}/region/create">
		Input new region:<br> <input type="text" name="newRegion"><br/>
		<input type="submit" value="Submit">
	</form>

</body>
</html>