package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet(name = "novaEmpresa", urlPatterns = { "/novaEmpresa" })
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovaEmpresaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			                                            throws ServletException, IOException {
        String nomeEmpresa = request.getParameter("nome");
        String data = request.getParameter("dataAbertura");
        Date dataAbertura = null;
        
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        	dataAbertura = sdf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
        
        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);
        
        Banco banco = new Banco();
        banco.adiciona(empresa);
		
//		PrintWriter out = response.getWriter(); 
//		out.println("<html>");
//		out.println("<body>"); 
//		out.println("Empresa " + nomeEmpresa + " Cadastrada com sucesso!"); 
//		out.println("</body>"); 
//		out.println("</html>");
        
        System.out.println("O servlet NovaEmpresaServlet foi chamado");
        
        request.setAttribute("empresa", empresa.getNome());
        response.sendRedirect("listaEmpresas");
        
        //Chamando o jsp
        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
        
        //Chamando um Servlet
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaEmpresas");
//        request.setAttribute("empresa", empresa.getNome());
//        requestDispatcher.forward(request, response);
	}

}
