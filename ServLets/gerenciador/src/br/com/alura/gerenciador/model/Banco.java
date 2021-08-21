package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();
	
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
