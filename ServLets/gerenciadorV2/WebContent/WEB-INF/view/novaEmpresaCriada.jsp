<%

String nomeEmpresa = (String) request.getAttribute("empresa");
System.out.println(nomeEmpresa);

%>

<html>
<body>
 Empresa <%  request.getAttribute("empresa") ; %> Cadastrada com sucesso
</body>
</html>