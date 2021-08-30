package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class RelatoriosService {

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private boolean system = true;
	private FuncionarioRepository funcionarioRepository;

	public RelatoriosService(FuncionarioRepository funcionarioRepository)
	{
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner)
	{
		while (system) {
			System.out.println("Qual acao de cargo deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionario por Nome Derived Query");
			System.out.println("2 - Busca funcionario por Cargo Derived Query Associacoes");
			System.out.println("3 - Busca funcionario por Nome / Salario Maior que / Data Contratacao JPQL");
			System.out.println("4 - Busca funcionario por Data Contratacao Native Query");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				buscaFuncionarioPorNome(scanner);
				break;
			case 2:
				buscaFuncionarioPorCargo(scanner);
				break;
			case 3:
				buscaFuncionarioNomeSalarioDataContratacao(scanner);
				break;
			case 4:
				buscaFuncionarioDataContratacao(scanner);
				break;

			default:
				system = false; 
				break;
			}
		}
	}
	
	private void buscaFuncionarioPorNome(Scanner scanner) {
		System.out.println("Qual o nome deseja Pesquisar ?");
		String nome = scanner.next();
		List<Funcionario> lista = funcionarioRepository.findByNomeFuncionario(nome);
		
		lista.forEach(System.out::println);
	}

	private void buscaFuncionarioPorCargo(Scanner scanner) {
		System.out.println("Qual o Cargo deseja Pesquisar ?");
		String nome = scanner.next();
		//List<Funcionario> lista = funcionarioRepository.findByCargoDescricao(nome);
		List<Funcionario> lista = funcionarioRepository.findByCargoDescricaoQuery(nome);
		
		lista.forEach(System.out::println);
	}

	private void buscaFuncionarioNomeSalarioDataContratacao(Scanner scanner) {
		System.out.println("Nome do Funcionario");
		String nomeFuncionario = scanner.next();

		System.out.println("Digite o salario");
		Double salario = scanner.nextDouble();

		System.out.println("Digite a data de contracao");
		String dataContratacao = scanner.next();
		
		List<Funcionario> lista = funcionarioRepository.findByNomeSalarioMaiorDataContratacaoQuery(nomeFuncionario, salario, LocalDate.parse(dataContratacao, formatter));
		
		lista.forEach(System.out::println);
	}

	private void buscaFuncionarioDataContratacao(Scanner scanner) {
		System.out.println("Digite a data de contracao");
		String dataContratacao = scanner.next();
		
		List<Funcionario> lista = funcionarioRepository.findByDataContratacaoNative(LocalDate.parse(dataContratacao, formatter));
		
		lista.forEach(System.out::println);
	}
	
}
