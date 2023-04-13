<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa" />
<c:url value="/unicaEntrada" var="linkServletNovaEmpresaAction" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Empresa</title>
</head>
<body>
	<!-- <form action="/gerenciador/novaEmpresa" method="post">  -->
	<form action="${linkServletNovaEmpresaAction}" method="post">
		<label for="nome">Nome:</label>
		<input type="text" name="nome" id="nome"/>
		
		<label for="data">Data:</label>
		<input type="text" name="dataAbertura" id="data"/>
		<input type="hidden" name="acao" id="acao" value="NovaEmpresa"/>
		
		<input type="submit" name="Salvar"></input>
	</form>
</body>
</html>