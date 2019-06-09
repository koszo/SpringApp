<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.sda.service.RegionServiceImpl"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LocationList</title>
</head>
<body>

<br>
<a method="get" href="http://localhost:8080/sdaSpringMVCApp/region/list"> Region List</a>
<a method="get" href="http://localhost:8080/sdaSpringMVCApp/country/list"> Country List</a>
<a method="get" href="http://localhost:8080/sdaSpringMVCApp/location/list"> Location List</a>
</br>


	<h1>Location List</h1>



	<p>${errorMessage}</p>

	<table border="1px">
		<tr>
			<td>LocationID</td>
			<td>Street Address</td>
			<td>Postal Code</td>
			<td>City</td>
			<td>State Province</td>
			<td>Country Name</td>
			<td>delete button</td>
			<td>Update Location</td>
		</tr>
		<c:forEach items="${locationList}" var="location">
			<tr>
				<td>${location.getLocationId()}</td>
				<td>${location.getStreetAddress()}</td>
				<td>${location.getPostalCode()}</td>
				<td>${location.getCity()}</td>
				<td>${location.getStateProvince()}</td>
				<td>${location.getCountry().getCountryName()}</td>
				<td><form method="post"
						action="${pageContext.request.contextPath}/location/delete">
						<input type="submit" value="Delete" name="delete"> <input
							type="hidden" value="${location.getLocationId()}" name="locationId">
					</form></td>
				<td>
					<form method="get"
						action="${pageContext.request.contextPath}/location/update">
						<input type="submit" value="Update" name="update"> <input
							type="hidden" value="${location.getLocationId()}" name="locationId">
					</form>
				</td>
				
				
			</tr>
		</c:forEach>
	</table>

	


	<a method="post"
		href=http://localhost:8080/sdaSpringMVCApp/location/create> Create new location </a>

</body>
</html>