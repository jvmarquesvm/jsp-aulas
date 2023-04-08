<% 	
	//Scriptlet
	String nomeEmpresa = (String) request.getAttribute("empresa");
	System.out.println(nomeEmpresa);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova Empresa</title>
</head>
<body>
	<!-- 3 formas de fazer um output para o navegador -->
	<h2>3 formas de fazer um output para o navegador utilizando scriptlet</h2>
	<p>Empresa <%  out.println(nomeEmpresa);  %> cadastrada com sucesso!</p>
	<p>Empresa <%= nomeEmpresa  %> cadastrada com sucesso!</p>
	<p>Empresa <%= (nomeEmpresa)  %> cadastrada com sucesso!</p>
	
	<!-- Utilizando Expression Language E.L -->
	<h2>Forma de fazer um output utilizando Expression Language E.L</h2>
	<c:if test="${not empty empresa}">
		<p>Empresa ${ empresa } cadastrada com sucesso!</p>
	</c:if>
	<c:if test="${empty empresa}">
		<p>Nenhuma emprea cadastrada!</p>
	</c:if>
</body>
</html>