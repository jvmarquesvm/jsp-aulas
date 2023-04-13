package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Pode definir mais que uma url para o servlet
//Servlet sendo iniciado na subida do servidor
//@WebServlet( urlPatterns = {"/oi", "/oioi"}, loadOnStartup = 1, description = "Servlet Inicial")
public class OiMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OiMundoServlet() {
        super();
        System.out.println("Criando OiMundoServlet!!");
    }
    
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			                                            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Oi mundo, parabéns vc escreveu o primeiro servlets.");
        out.println("</body>");
        out.println("</html>");
        
        System.out.println("O servlet OiMundoServlet foi chamado");
	}

}
