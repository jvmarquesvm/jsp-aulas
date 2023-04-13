package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class EmpresasService
 */
@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public EmpresasService() {
        super();
        System.out.println("Criando lista Empresas Json!!");
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			                                                      throws ServletException, IOException {
		 System.out.println("Empresas Json");
		 List<Empresa> empresas = new Banco().getEmpresas();
		 
		 String headerAccept = request.getHeader("Accept");
		 
		 System.out.println(headerAccept);
		 
		 //JSON
		 if(headerAccept.contains("json")) {
			 Gson gson = new Gson();
			 String json = gson.toJson(empresas);
			 
			 response.setContentType("application/json");
			 response.getWriter().print(json);
		 //XML
		 } else if (headerAccept.contains("xml")) {
			 XStream xstream = new XStream();
			 xstream.alias("empresa", Empresa.class);
			 String xml = xstream.toXML(empresas);
			 
			 response.setContentType("application/xml");
			 response.getWriter().print(xml);
		 } else {
			 response.setContentType("application/json");
			 response.getWriter().print("{'message':'no content'}");
		 }
		 
	}

}
