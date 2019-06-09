<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.sda.service.RegionServiceImpl"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Country List</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<br>
<p>Hello, <sec:authentication property="principal.username" /></p>

	<h1>Country List</h1>

<a method="get" href="http://localhost:8080/sdaSpringMVCApp/country/create"> Click here to introduce new country</a>


<p>${errorMessage}</p>

	<table border="1px">
		<tr>
			<td>CountryID</td>
			<td>CountryName</td>
			<td>Country Region</td> 
			<sec:authorize access="hasRole('ROLE_ADMIN')">
			<td>deletebutton</td>
			<td>Update Country</td>
			</sec:authorize>
			<td>Show Locations</td>
		</tr>
		<c:forEach items="${countryList}" var="country">
			<tr>
				<td>${country.getCountryId()}</td>
				<td>${country.getCountryName()}</td>
				<td>${country.getRegion().getRegionName()}</td> 
				<sec:authorize access="hasRole('ROLE_ADMIN')">
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
				</sec:authorize>
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