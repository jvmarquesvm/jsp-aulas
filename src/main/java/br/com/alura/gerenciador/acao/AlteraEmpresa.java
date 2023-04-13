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

public class AlteraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) 
			                                  throws IOException, ServletException {
		System.out.println("A acao AlteraEmpresa foi chamada");
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
        //response.sendRedirect("unicaEntrada?acao=ListaEmpresas");		
        return "redirect:unicaEntrada?acao=ListaEmpresas";
	}

}