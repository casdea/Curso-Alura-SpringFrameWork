package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private boolean system = true;

	private final CrudCargoService crudCargoService;
	private final CrudUnidadeService crudUnidadeService;
	private final CrudFuncionarioService crudFuncionarioService;

	public SpringDataApplication(CrudCargoService crudCargoService, CrudUnidadeService crudUnidadeService,
			CrudFuncionarioService crudFuncionarioService) {
		this.crudCargoService = crudCargoService;
		this.crudUnidadeService = crudUnidadeService;
		this.crudFuncionarioService = crudFuncionarioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual acao voce quer executar:");
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir Cargo");
			System.out.println("2 - Atualizar Cargo");
			System.out.println("3 - Visualizar Cargo");
			System.out.println("4 - Excluir Cargo");
			System.out.println("5 - Exibir Todos Cargos");

			System.out.println("6 - Inserir Unidade");
			System.out.println("7 - Atualizar Unidade");
			System.out.println("8 - Visualizar Unidade");
			System.out.println("9 - Excluir Unidade");
			System.out.println("10 - Exibir Todas Unidades");

			System.out.println("11 - Inserir Funcioanrio");
			System.out.println("12 - Atualizar Funcionario");
			System.out.println("13 - Visualizar Funcionario");
			System.out.println("14 - Excluir Funcionario");
			System.out.println("15 - Exibir Todos Funcionaro");

			int action = scanner.nextInt();
			if (action == 1) {
				crudCargoService.salvar(scanner);
			} else if (action == 2) {
				crudCargoService.atualizar(scanner);
			} else if (action == 3) {
				crudCargoService.visualizar(scanner);
			} else if (action == 4) {
				crudCargoService.deletar(scanner);
			} else if (action == 5) {
				crudCargoService.visualizarTodos(scanner);
			} else if (action == 6) {
				crudUnidadeService.salvar(scanner);
			} else if (action == 7) {
				crudUnidadeService.atualizar(scanner);
			} else if (action == 8) {
				crudUnidadeService.visualizar(scanner);
			} else if (action == 9) {
				crudUnidadeService.deletar(scanner);
			} else if (action == 10) {
				crudUnidadeService.visualizarTodos(scanner);
			} else if (action == 11) {
				crudFuncionarioService.salvar(scanner);
			} else if (action == 12) {
				crudFuncionarioService.atualizar(scanner);
			} else if (action == 13) {
				crudFuncionarioService.visualizar(scanner);
			} else if (action == 14) {
				crudFuncionarioService.deletar(scanner);
			} else if (action == 15) {
				crudFuncionarioService.visualizarTodos(scanner);

			} else {
				system = false;
			}

		}
	}

}
