<%

String nomeEmpresa = (String) request.getAttribute("empresa");
System.out.println(nomeEmpresa);

%>

<html>
<body>
 Empresa <%  request.getAttribute("empresa") ; %> Cadastrada com sucesso1
 Empresa <% out.println(nomeEmpresa); %> Cadastrada com sucesso2
 Empresa <%=nomeEmpresa %> Cadastrada com sucesso3
</body>
</html>