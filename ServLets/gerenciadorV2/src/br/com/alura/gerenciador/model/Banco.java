package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
		
    static {
    	empresas.add(new Empresa("GOOGLE",new Date("01/01/2001")));
    	empresas.add(new Empresa("ALURA",new Date("01/02/2001")));
    	empresas.add(new Empresa("MICROSOFT",new Date("01/03/2001")));
    	
    	usuarios.add(new Usuario("ADM","123"));
    	usuarios.add(new Usuario("JOSE","123"));
    }
	
	public void adiciona(Empresa empresa) {
		// TODO Auto-generated method stub
		Banco.empresas.add(empresa); 
	}

	public List<Empresa> getEmpresas()
	{		
		return Banco.empresas;
	}

	public void removeEmpresa(Integer id) {
		Empresa empresaEncontrado = null;
		
		for (Empresa empresa : empresas) {
			if (empresa.getId().equals(id)) {
				empresaEncontrado = empresa;
				break;
			}
		}
		
		if (empresaEncontrado != null) {
			empresas.remove(empresaEncontrado);
		}
	}

	public Empresa findEmpresaById(Integer id) {
		// TODO Auto-generated method stub

		for (Empresa empresa : empresas) {
			if (empresa.getId().equals(id)) {
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
