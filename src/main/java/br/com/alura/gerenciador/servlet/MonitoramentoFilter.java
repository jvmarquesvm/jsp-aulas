package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter( urlPatterns = "/unicaEntrada")
public class MonitoramentoFilter implements Filter {
	
    /**
     * Default constructor. 
     */
    public MonitoramentoFilter() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			                                                 throws IOException, ServletException {
		System.out.println("O filter Monitoramento foi chamado");
		long antes = System.currentTimeMillis();
		String acao = request.getParameter("acao");
		
		//Executa a ação
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		System.out.println("Tempo de execução: Ação: " + acao + ": " + (depois - antes) );
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
