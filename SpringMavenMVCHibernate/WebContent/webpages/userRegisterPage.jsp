<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

	<form:form action="register" method="post" modelAttribute="userModel">
	

		User Name: <form:input path="userName" />
		
		</br>
		
		First Name: <form:input path="fName" />
		</br>
		Last Name:  <form:input path="lName" />
		</br>

		Password: <form:input path="userPassword" />
		</br>
		</br>
		<input type="submit" value="Regiser User">


		
	</form:form>
</body>
</html>