package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostraEmpresaServlet
 */
@WebServlet(name = "alteraEmpresa", urlPatterns = { "/alteraEmpresa" })
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlteraEmpresaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("O servlet AlteraEmpresaServlet foi chamado");
        String nomeEmpresa = request.getParameter("nome");
        String data = request.getParameter("dataAbertura");
        Date dataAbertura = null;
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
        
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        	dataAbertura = sdf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Empresa empresaPorId = banco.buscaEmpresaPorId(id);
		
		empresaPorId.setNome(nomeEmpresa);
		empresaPorId.setDataAbertura(dataAbertura);
		
		
        request.setAttribute("empresa", empresaPorId.getNome());
        response.sendRedirect("listaEmpresas");
		

	}

}
