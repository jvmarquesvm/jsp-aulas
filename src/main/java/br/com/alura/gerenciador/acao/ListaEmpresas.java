package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) 
			                                             throws ServletException, IOException {
		
//		HttpSession session = request.getSession();
//		
//		if(session.getAttribute("usuarioLogado") == null) {
//			return "redirect:unicaEntrada?acao=LoginForm";
//		}
		
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		
		System.out.println("A acao ListaEmpresas foi chamada");        
		
		request.setAttribute("empresas", empresas);
		//RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaEmpresas.jsp");
		//requestDispatcher.forward(request, response);
		
		return "forward:listaEmpresas.jsp";
	}
}
