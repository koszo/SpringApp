<br>
<a href="http://localhost:8080/sdaSpringMVCApp/region/list"> Region List</a>
<a href="http://localhost:8080/sdaSpringMVCApp/country/list"> Country List</a>
<a href="http://localhost:8080/sdaSpringMVCApp/location/list"> Location List</a>
<br>
<br>
<form method="post"  action="${pageContext.request.contextPath}/logout">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<input type="submit" value="logout" name="logout">
</form>
<br>