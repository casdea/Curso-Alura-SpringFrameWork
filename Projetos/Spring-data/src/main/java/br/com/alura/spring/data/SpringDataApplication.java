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
import br.com.alura.spring.data.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private boolean system = true;

	private final CrudCargoService crudCargoService;
	private final CrudUnidadeService crudUnidadeService;
	private final CrudFuncionarioService crudFuncionarioService;
	private final RelatoriosService relatoriosService;

	public SpringDataApplication(CrudCargoService crudCargoService, CrudUnidadeService crudUnidadeService,
			CrudFuncionarioService crudFuncionarioService, RelatoriosService relatoriosService) {
		this.crudCargoService = crudCargoService;
		this.crudUnidadeService = crudUnidadeService;
		this.crudFuncionarioService = crudFuncionarioService;
		this.relatoriosService = relatoriosService; 
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
			System.out.println("1 - Cargos");
			System.out.println("2 - Unidade");
			System.out.println("3 - Funcionarios");
			System.out.println("4 - Relatorios");

			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				this.crudCargoService.inicial(scanner);
				break;
			case 2:
				this.crudUnidadeService.inicial(scanner);
				break;
			case 3:
				this.crudFuncionarioService.inicial(scanner);
				break;
			case 4:
				this.relatoriosService.inicial(scanner);
				break;

			default:
				system = false;
				break;
			}
			
		}
	}

}
