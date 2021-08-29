package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.service.CrudCargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private boolean system = true;

	private final CrudCargoService crudCargoService;

	public SpringDataApplication(CrudCargoService crudCargoService) {
		this.crudCargoService = crudCargoService;
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
			System.out.println("5 - Exibir Todos");

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
			} else {
				system = false;
			}

		}
	}

}
