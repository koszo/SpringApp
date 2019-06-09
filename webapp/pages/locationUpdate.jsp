<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update location</title>
</head>
<body>
	<br>
	<h1>Update existing location</h1>


	<br />


	<form method="post"
		action="${pageContext.request.contextPath}/location/update">
		<input type="text" value="${location.getStreetAddress()}" name="streetAddress"> 
		<input type="text" value="${location.getPostalCode()}" name="postalCode">
		<input type="text" value="${location.getCity()}" name="city">
		<input type="text" value="${location.getStateProvince()}" name="stateProvince">
		<input type="hidden" value="${location.getLocationId()}" name="locationId">
			
			<select name="countryId">
			<c:forEach items="${countryList}" var="country">
				<option value="${country.getCountryId()}" ${country.getCountryId() == location.getCountry().getCountryId() ? 'selected' : ''}> ${country.getCountryName()}</option>
			</c:forEach>
		</select> 
		<input
			type="submit" value="Update">
	</form>





</body>
</html>