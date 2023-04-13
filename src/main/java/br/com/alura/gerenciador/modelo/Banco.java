package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	//Atributo estáticos
	private static List<Empresa> empresas = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	private static List<Usuario> usuarios = new ArrayList<>();
	
	//É executado quando a VM carrega a classe 
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(chaveSequencial++);
		empresa1.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Google");
		empresas.add(empresa1);
		empresas.add(empresa2);
		
		Usuario u1 = new Usuario();
	    u1.setLogin("j.victor");
	    u1.setSenha("12345");

	    Usuario u2 = new Usuario();
	    u2.setLogin("ana");
	    u2.setSenha("12345");

	    usuarios.add(u1);
	    usuarios.add(u2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		Banco.empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = empresas.iterator();
		
		while (it.hasNext()) {
			Empresa empresa = it.next();
			if(empresa.getId() == id) {
				it.remove();
			}
		}
		//Não usar o for com ArrayList - Usando for enquanto está iterando sobre essa lista
		//não é possível modificar
		//Para modificar a lista enquanto itera, utilizar o Iterator
	}

	public Empresa buscaEmpresaPorId(Integer id) {
		for (Empresa empresa : empresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
		
	}
	
	public Usuario existeUsuario(String login, String senha) {
	    for(Usuario usuario : usuarios) {
	        if(usuario.ehIgual(login, senha)) { 
	            return usuario;
	        }
	    }
	    return null;
	}

}
