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
		<label for="input-1">Nome:</label> <input id="input-1" name="nome"
			placeholder="Text" maxlength="65" autofocus="true" required="true"
			type="text" />
			<input type="submit" value="Registrar" id="button-1"/>
	</form>

</body>
</html>