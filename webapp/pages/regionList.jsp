<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.sda.service.RegionServiceImpl"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>regionList</title>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>



	<h1>region List</h1>




	<p>${errorMessage}</p>

	<table border="1px">
		<tr>
			<td>RegionID</td>
			<td>RegionName</td>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
			<td>delete button</td>
			<td>Update Region</td>
			</sec:authorize>
			<td>List Countries</td>
		</tr>
		<c:forEach items="${regionList}" var="region">
			<tr>
				<td>${region.getRegionId()}</td>
				<td>${region.getRegionName()}</td>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<td><form method="post"
						action="${pageContext.request.contextPath}/region/delete">
						<input type="submit" value="Delete" name="delete"> <input
							type="hidden" value="${region.getRegionId()}" name="regionId">
					</form></td>
					
				<td>
					<form method="get"
						action="${pageContext.request.contextPath}/region/update">
						<input type="submit" value="Update" name="update"> <input
							type="hidden" value="${region.getRegionId()}" name="regionId">
					</form>
				</td>
				</sec:authorize>
				<td>
					<form method="get"
						action="${pageContext.request.contextPath}/country/listbyregion">
						<input type="submit" value="Show Countries" name="countryList"> <input
							type="hidden" value="${region.getRegionId()}" name="regionId">
					</form>				
				</td>
			</tr>
		</c:forEach>
	</table>

	<form method="post"
		action="${pageContext.request.contextPath}/region/create">
		Input new region:<br> <input type="text" name="newRegion"><br />
		<input type="submit" value="Submit">
	</form>


	<a method="get"
		href=http://localhost:8080/sdaSpringMVCApp/region/create> Create
		New region </a>

</body>
</html>