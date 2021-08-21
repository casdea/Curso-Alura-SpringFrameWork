<%@page import="br.com.alura.gerenciador.model.Empresa"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empresas</title>
</head>
<body>
<ul>
        Lista Empresas <br/>

		<c:forEach items="${empresas}" var="empresa" >
		
			<li> ${empresa.nome} </li>
		
		</c:forEach>

</ul>
</body>
</html>