package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet Filter implementation class ControladorFilter
 */
@WebFilter("/ControladorFilter")
public class ControladorFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ControladorFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) 
			                                                                 throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("O filter Controlador foi chamado");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");
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

		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
