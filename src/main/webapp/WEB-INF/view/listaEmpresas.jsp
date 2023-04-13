<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.List,br.com.alura.gerenciador.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Links de acesso direto - não utilizado -->
<c:url value="/formNovaEmpresa.jsp" var="linkServletCriaEmpresa" />
<c:url value="/removeEmpresa" var="linkServletRemoveEmpresa" />
<c:url value="/mostraEmpresa" var="linkServletEditaEmpresa" />

<c:url value="/unicaEntrada?acao=NovaEmpresaForm" var="linkServletCriaEmpresaAction" />
<c:url value="/unicaEntrada?acao=MostraEmpresa" var="linkServletEditaEmpresaAction" />
<c:url value="/unicaEntrada?acao=RemoveEmpresa" var="linkServletRemoveEmpresaAction" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lista Empresas</title>
</head>
<body>
	<h1>Lista de Empresas:</h1>
	<h2>for utilizando scriptlet</h2>
	<p>Usuário Logado: ${usuarioLogado.login }</p> <!-- <a href="${linkServletLogoutAction}" > Logout</a>  -->
	<c:import url="logOut.jsp" />
	<h4>Criar Empresa</h4>
	<a href="${linkServletCriaEmpresa}">Clique aqui</a>
	<span>(Não permite acesso direto ao jsp)</span>
	
	<ul>
		<%
			List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");
			for (Empresa empresa : empresas) {
		%>
	      	<li> 
	      		<%=  empresa.getNome() %>  
	      	</li>
	    <%
	        }
		 %>
	</ul>
	<br />
	
	<h2>Java Standard Taglib</h2>
	<h2>for utilizando Taglib</h2>
	<h4>Criar Empresa </h4>
	<a href="${linkServletCriaEmpresaAction}">Clique aqui</a>
	
	
	<c:if test="${not empty empresa}">
		<p>Empresa ${ empresa } cadastrada com sucesso!</p>
	</c:if>
	
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>
				${empresa.nome} 
			    <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> 
			    <a href="${linkServletEditaEmpresaAction}&id=${empresa.id}">Editar</a> 
			    <a href="${linkServletRemoveEmpresaAction}&id=${empresa.id}">Remover</a> 
			</li>
		</c:forEach>
	</ul>
</body>
</html> 