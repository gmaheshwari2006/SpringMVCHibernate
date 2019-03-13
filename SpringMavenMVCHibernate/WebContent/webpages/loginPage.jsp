<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	
</script>
<body>
	Welcome to radical tech for spring
	</br> Institute Name is: ${name}

	<form:form action="login" method="get" modelAttribute="user">
		User Name: <form:input path="userName" />
		</br>
		Password: <form:input path="userPassword" />
		</br>
		<input type="submit" value="Enter">
		<a href="<c:url value="/registerPage"/>">RegisterUser</a>
	</form:form>
</body>
</html>