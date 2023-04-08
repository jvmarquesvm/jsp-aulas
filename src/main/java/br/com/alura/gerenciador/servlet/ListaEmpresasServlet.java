package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresasServlet
 */
@WebServlet(name = "listaEmpresas", urlPatterns = { "/listaEmpresas" })
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaEmpresasServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		
//		PrintWriter out = response.getWriter();
//        out.println("<html>");
//        out.println("<body>");
//	        out.println("<ul>");
//	        for (Empresa empresa : empresas) {
//	        	out.println("<li>" + empresa.getNome() + "</li>");
//	        }
//	        out.println("</ul>");
//        out.println("</body>");
//        out.println("</html>");
		
		System.out.println("O servlet ListaEmpresasServlet foi chamado");        
		
		request.setAttribute("empresas", empresas);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaEmpresas.jsp");
		requestDispatcher.forward(request, response);
	}

}
