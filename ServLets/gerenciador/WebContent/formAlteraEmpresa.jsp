<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value ="/alteraEmpresa" var="linkAlterar" ></c:url>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterando Empresa</title>
</head>

<body>
	<form name="formAlteraEmpresa" id="form-1"
		action="${linkAlterar}" method="post">
		Nome: <input name="nome" type="text" value="${empresa.nome}" />
		Data Fundacao: <input name="dataFundacao" type="text" value="<fmt:formatDate value="${empresa.dataFundacao}" pattern="dd/MM/yyyy"/>"/>
		<input hidden="true" type="text" name="id" value="${empresa.id}">
		<input type="submit" value="Alterar"/>
	</form>

</body>
</html>