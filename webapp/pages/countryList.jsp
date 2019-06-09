<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.sda.service.RegionServiceImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Country List</title>
</head>
<body>
<br>
<a method="get" href="http://localhost:8080/sdaSpringMVCApp/region/list"> Region List</a>
<a method="get" href="http://localhost:8080/sdaSpringMVCApp/country/list"> Country List</a>
<a method="get" href="http://localhost:8080/sdaSpringMVCApp/location/list"> Location List</a>
</br>
<br>
<br>


	<h1>Country List</h1>

<a method="get" href="http://localhost:8080/sdaSpringMVCApp/country/create"> Click here to introduce new country</a>


<p>${errorMessage}</p>

	<table border="1px">
		<tr>
			<td>CountryID</td>
			<td>CountryName</td>
			<td>Country Region</td> 
			<td>deletebutton</td>
			<td>Update Country</td>
			<td>Show Locations</td>
		</tr>
		<c:forEach items="${countryList}" var="country">
			<tr>
				<td>${country.getCountryId()}</td>
				<td>${country.getCountryName()}</td>
				<td>${country.getRegion().getRegionName()}</td> 
				<td><form method="post"
						action="${pageContext.request.contextPath}/country/delete">
						<input type="submit" value="Delete" name="delete"> <input
							type="hidden" value="${country.getCountryId()}" name="countryId">
					</form></td>
				<td>
					<form method="get"
						action="${pageContext.request.contextPath}/country/update">
						<input type="submit" value="Update" name="update"> <input
							type="hidden" value="${country.getCountryId()}" name="countryId">
					</form>
				</td>
				<td>
					<form method="get"
						action="${pageContext.request.contextPath}/location/listByCountry">
						<input type="submit" value="Show Locations" name="locationList"> <input
							type="hidden" value="${country.getCountryId()}" name="countryId">
					</form>				
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>