<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update country</title>
</head>
<body>
	<br>
	<h1>Update existing Country</h1>


	<br />


	<form method="post"
		action="${pageContext.request.contextPath}/country/update">
		<input type="text" value="${country.getCountryName()}"
			name="countryName"> <input type="hidden"
			value="${country.getCountryId()}" name="countryId">  <select name="regionId">
			<c:forEach items="${regionList}" var="region">
				<option value="${region.getRegionId()}">${region.getRegionName()}</option>
			</c:forEach>
		</select> 
		<input
			type="submit" value="Update">
	</form>





</body>
</html>