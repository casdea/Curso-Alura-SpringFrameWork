<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/api" var="linkApi" />

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form action="${linkApi}" method="post">

		Login: <input type="text" name="login" /> senha: <input
			type="password" name="senha" /> <input type="hidden" name="acao"
			value="Login"> <input type="submit" />
	</form>

</body>
</html>