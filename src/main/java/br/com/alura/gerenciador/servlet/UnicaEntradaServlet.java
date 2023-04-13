package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresaForm;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/unicaEntrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnicaEntradaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			                                                 throws ServletException, IOException {
		
//		HttpSession session = request.getSession();
		String paramAcao = request.getParameter("acao");
//		boolean ehUmaAcaoProtegida = !( paramAcao.equals("Login") || paramAcao.equals("LoginForm") );
//		
//		if(session.getAttribute("usuarioLogado") == null && ehUmaAcaoProtegida) {
//			response.sendRedirect("unicaEntrada?acao=LoginForm");
//			return;
//		}
		
        String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		String retorno = "";
		
		try {
            Class<?> classe = Class.forName(nomeDaClasse); 
            Acao acao = (Acao) classe.newInstance();
            retorno = acao.executa(request,response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }
		
		String[] tipoEndereco = retorno.split(":");
		
		if (tipoEndereco[0].equals("forward")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/" + tipoEndereco[1]);
			requestDispatcher.forward(request, response);
		}
		
		if (tipoEndereco[0].equals("redirect")) {
			response.sendRedirect(tipoEndereco[1]);
		}
		
//		if( paramAcao.equals("ListaEmpresas") ) {
//			System.out.println("Listando Empresas");
//			ListaEmpresas listaEmpresas = new ListaEmpresas();
//			retorno = listaEmpresas.executa(request, response);
//			
//		} else if ( paramAcao.equals("RemoveEmpresa") ) {
//			System.out.println("Removendo Empresa");
//			RemoveEmpresa removeEmpresa = new RemoveEmpresa();
//			retorno = removeEmpresa.executa(request, response);
//			
//		} else if ( paramAcao.equals("MostraEmpresa") ) {
//			System.out.println("Mostrando Empresa");
//			MostraEmpresa mostraEmpresa = new MostraEmpresa();
//			retorno = mostraEmpresa.executa(request, response);
//			
//		} else if ( paramAcao.equals("AlteraEmpresa") ) {
//			System.out.println("Alterando Empresa");
//			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
//			retorno = alteraEmpresa.executa(request, response);
//			
//		} else if ( paramAcao.equals("NovaEmpresa") ) {
//			System.out.println("Nova Empresa");
//			NovaEmpresa novaEmpresa = new NovaEmpresa();
//			retorno = novaEmpresa.executa(request, response);
//		
//		} else if ( paramAcao.equals("NovaEmpresaForm") ) {
//			System.out.println("Nova Empresa Formulário");
//			NovaEmpresaForm novaEmpresaForm = new NovaEmpresaForm();
//			retorno = novaEmpresaForm.executa(request, response);
//		
//		}
		
	}

}
