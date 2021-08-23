<%@page import="br.com.alura.gerenciador.model.Empresa"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
        <a href="/gerenciador/api?acao=InsereEmpresa">nova Empresa</a>
		<c:forEach items="${empresas}" var="empresa" >
		
			<li> 
			   ${empresa.nome} - <fmt:formatDate value="${empresa.dataFundacao}" pattern="dd/MM/yyyy"/>
			   <a href="/gerenciador/api?acao=MostraEmpresa&id=${empresa.id}">edita</a>
			   <a href="/gerenciador/api?acao=RemoveEmpresa&id=${empresa.id}">remove</a>   
			</li>
		
		</c:forEach>

</ul>
</body>
</html>