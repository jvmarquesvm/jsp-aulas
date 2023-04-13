package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) 
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
        System.out.println("A acao NovaEmpresa foi chamada");
        
        request.setAttribute("empresa", empresa.getNome());
        //response.sendRedirect("unicaEntrada?acao=ListaEmpresas");
        return "redirect:unicaEntrada?acao=ListaEmpresas";
        
	}
}
