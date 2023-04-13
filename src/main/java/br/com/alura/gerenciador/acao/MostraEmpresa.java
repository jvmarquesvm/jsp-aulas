package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) 
			                                                 throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println("A acao MostraEmpresa foi chamada");  
		
		Banco banco = new Banco();
		Empresa empresaPorId = banco.buscaEmpresaPorId(id);
		
		request.setAttribute("empresa", empresaPorId);
		//RequestDispatcher requestDispatcher = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		//requestDispatcher.forward(request, response);		
		return "forward:formAlteraEmpresa.jsp";
	}

}
