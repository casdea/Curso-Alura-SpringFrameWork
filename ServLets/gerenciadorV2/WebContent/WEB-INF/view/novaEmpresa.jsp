<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
  <c:if test="${not empty empresa}">
     Empresa ${ empresa } Cadastrada com sucesso
  </c:if>
  <c:if test="${empty empresa}">
      Nao tem empresa criada
  </c:if>
 
</body>
</html>