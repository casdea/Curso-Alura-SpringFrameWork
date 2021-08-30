package br.com.alura.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.specification.SpecificationFuncionario;

public class RelatorioFuncionarioDinamico {

	private final FuncionarioRepository funcionarioRepository;

	public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
	
		this.funcionarioRepository = funcionarioRepository;
	}
	
	
	public void inicial(Scanner scanner) {
		System.out.print("Digite o nome ");
		String nomeFuncionario = scanner.next();

		if (nomeFuncionario.equalsIgnoreCase("NULL"))
		{
			nomeFuncionario = null;
		}
		
		System.out.print("Digite a matricula ");
		String nrMatricula = scanner.next();

		if (nrMatricula.equalsIgnoreCase("NULL"))
		{
			nrMatricula = null;
		}

		System.out.print("Digite o Salario ");
		Double salario = scanner.nextDouble();

		if (salario == 0) {
			salario = null;
		}
		
		List<Funcionario> funcionarios = funcionarioRepository.findAll(
				Specification.where(
						SpecificationFuncionario.nomeFuncionario(nomeFuncionario))
					.or(SpecificationFuncionario.nrMatricula(nrMatricula))
					.or(SpecificationFuncionario.salario(salario))
				);
		funcionarios.forEach(System.out::println);
	}
	
}
