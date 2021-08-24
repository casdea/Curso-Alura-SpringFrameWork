<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value ="/api" var="linkNova" ></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrando Nova Empresa</title>
</head>

<body>
<c:import url="logout-parcial.jsp"></c:import>

	<form name="formNovaEmpresa" id="form-1"
		action="${linkNova}" method="post">
		Nome: <input name="nome" type="text" />
		Data Fundacao: <input name="dataFundacao" type="date" />
		<input hidden="true" type="text" name="acao" value="NovaEmpresa">
			<input type="submit" value="Registrar"/>
	</form>

</body>
</html>