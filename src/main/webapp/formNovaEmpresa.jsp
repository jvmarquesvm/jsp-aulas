<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Empresa</title>
</head>
<body>
	<!-- <form action="/gerenciador/novaEmpresa" method="post">  -->
	<form action="${linkServletNovaEmpresa}" method="post">
		<label for="nome">Nome:</label>
		<input type="text" name="nome" id="nome"/>
		
		<label for="data">Data:</label>
		<input type="text" name="dataAbertura" id="data"/>
		
		<input type="submit" name="Salvar"></input>
	</form>
</body>
</html>