package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();
	
    static {
    	empresas.add(new Empresa(1,"GOOGLE",new Date("01/01/2001")));
    	empresas.add(new Empresa(1,"ALURA",new Date("01/02/2001")));
    	empresas.add(new Empresa(1,"MICROSOFT",new Date("01/03/2001")));
    }
	
	public void adiciona(Empresa empresa) {
		// TODO Auto-generated method stub
		Banco.empresas.add(empresa); 
		System.out.println("Empresas cadastradas "+Banco.empresas.size());
	}

	public List<Empresa> getEmpresas()
	{		
		System.out.println("Empresas retornadas "+Banco.empresas.size());
		return Banco.empresas;
	}
}
