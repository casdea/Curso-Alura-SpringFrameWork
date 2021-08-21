<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value ="/novaEmpresa" var="linkNova" ></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrando Nova Empresa</title>
</head>

<body>
	<form name="formNovaEmpresa" id="form-1"
		action="${linkNova}" method="post">
		Nome: <input name="nome" type="text" />
		Data Fundacao: <input name="dataFundacao" type="date" />
			<input type="submit" value="Registrar"/>
	</form>

</body>
</html>