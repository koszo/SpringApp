<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>country create</title>
</head>
<body>

	<h1>Add Country</h1>

	<br />
	<form method="post"
		action="${pageContext.request.contextPath}/country/create">
		Input new country:<br> <input type="text" name="newCountryName"><br />
		<br> Input new country ID: <br>
		<input type="text" name="newCountryId" minlength="2" maxlength="2">
		<br> 
		<select name="regionId">
			<c:forEach items="${regionList}" var="region">
				<option value="${region.getRegionId()}">${region.getRegionName()}</option>
			</c:forEach>
		</select> <br> 
		<input type="submit" value="Submit">
	</form>

</body>
</html>