<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<p>${errorMessage}</p>


<form method="post"  action="${pageContext.request.contextPath}/login">
Input user name: <br> <input type="text" name="username"><br />
<br> Input password <br>
<input type="text" name="password"><br>
<input type="submit" value="Login">
<br> 
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>






</body>
</html>