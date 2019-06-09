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

	<h1>Add location</h1>

	<br />
	<form method="post"
		action="${pageContext.request.contextPath}/location/create">
		Input new location<br> <input type="text" name="newLocationId"><input type="text" name="newAddress">
		<input type="text" name="newPostalCode"><input type="text" name="newCity"><input type="text" name="newStateProvince">
		<select name="countryId">
			<c:forEach items="${countryList}" var="country">
				<option value="${country.getCountryId()}">${country.getCountryName()}</option>
			</c:forEach>
		</select> <br> <br />
		<input type="submit" value="Submit">
	</form>

</body>
</html>