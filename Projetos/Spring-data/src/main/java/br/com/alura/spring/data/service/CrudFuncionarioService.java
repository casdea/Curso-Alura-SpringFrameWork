package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecaoClasseDto;
import br.com.alura.spring.data.orm.FuncionarioProjecaoInterface;
import br.com.alura.spring.data.orm.Unidade;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.repository.UnidadeRepository;

@Service
public class CrudFuncionarioService {

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private final FuncionarioRepository funcionarioRepository;
	private final UnidadeRepository unidadeRepository;
	private final CargoRepository cargoRepository;
	private boolean system = true;

	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository,
			UnidadeRepository unidadeRepository) {
		this.funcionarioRepository = funcionarioRepository;
		this.cargoRepository = cargoRepository;
		this.unidadeRepository = unidadeRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao de funcionario deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Excluir");
			System.out.println("5 - Exibir");
			System.out.println("6 - Popular Tabela");
			System.out.println("7 - Exibir Ordenado");
			System.out.println("8 - Exibir Projecao Interface");
			System.out.println("9 - Exibir Projecao Classe Dto");
			System.out.println("10 - Relatorios Dinamicos ");
			
			int action = scanner.nextInt();

			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar(scanner);
				break;
			case 4:
				deletar(scanner);
				break;
			case 5:
				visualizarTodos(scanner);
				break;
			case 6:
				popularTabela(scanner);
				break;
			case 7:
				visualizarTodosPaginaOrdenado(scanner);
				break;
			case 8:
				visualizarProjecaoInterface(scanner);
				break;
			case 9:
				visualizarProjecaoClasseDto(scanner);
				break;
			case 10:
				relatorioDinamicos(scanner);
				break;

			default:
				system = false;
				break;
			}
		}
	}

	private void relatorioDinamicos(Scanner scanner) {
		// TODO Auto-generated method stub
		RelatorioFuncionarioDinamico relatorioFuncionarioDinamico = new RelatorioFuncionarioDinamico(funcionarioRepository);
		relatorioFuncionarioDinamico.inicial(scanner);		
	}

	private void visualizarProjecaoInterface(Scanner scanner) {
		// TODO Auto-generated method stub

		List<FuncionarioProjecaoInterface> lista = funcionarioRepository.findBySalarioNativeProjecaoInterface();
		lista.forEach(f -> System.out.println(" Funcionario id: "+f.getId()+" Nome: "+f.getNome()+" Salario: "+f.getSalario()));
	}

	private void visualizarProjecaoClasseDto(Scanner scanner) {
		// TODO Auto-generated method stub

		List<FuncionarioProjecaoClasseDto> lista = funcionarioRepository.findBySalarioNativeProjecaoClasseDto();
		lista.forEach(f -> System.out.println(" Funcionario id: "+f.getId()+" Nome: "+f.getNomeFuncionario()+" Salario: "+f.getSalario()));
	}

	private void visualizarTodosPaginaOrdenado(Scanner scanner) {
		System.out.println("Qual a pagina ?");
		Integer pagina = scanner.nextInt();
		
		Pageable page = PageRequest.of(pagina, 15, Sort.by(Sort.Direction.ASC,"nomeFuncionario"));
		
		Page<Funcionario> lista = funcionarioRepository.findAll(page);

		if (lista == null || lista.getSize() == 0) {
			System.out.println("Nenhum funcionario encontrado ");
			return;
		}

		System.out.println("Listagem de Funcionarios");
		System.out.println("Pagina Atual "+lista.getNumber());
		System.out.println("Total de Elementos "+lista.getTotalElements());
		System.out.println("Total de Paginas "+lista.getTotalPages());
		
		lista.forEach(System.out::println);

				
		System.out.println("Exibido");
		
	}

	private void popularTabela(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("Quantos Registros ?");
		int qtde = scanner.nextInt();
		
		for (int i = 0; i < qtde; i++) {
			Funcionario funcionario = new Funcionario();
			funcionario.setNomeFuncionario("Funcionario "+i);
			funcionario.setNrMatricula(String.valueOf(i));
			funcionario.setSalario(1300D);
			funcionario.setDataContratacao(LocalDate.parse("01/01/2020", formatter));
			funcionario.setCargo(cargoRepository.findById(6).get());
			funcionario.setUnidade(unidadeRepository.findById(1).get());
			funcionarioRepository.save(funcionario);
			System.out.println("Incluindo Registro "+i);
		}
		
	}

	public void salvar(Scanner scanner) {
		System.out.println("Nome do Funcionario");
		String nomeFuncioanrio = scanner.next();
		System.out.println("Nr da Matricula");
		String nrMatricula = scanner.next();

		System.out.println("Digite o salario");
		Double salario = scanner.nextDouble();

		System.out.println("Digite a data de contracao");
		String dataContratacao = scanner.next();

		Optional<Cargo> cargoOpcional = obterIdCargo(scanner);

		if (cargoOpcional == null || cargoOpcional.get() == null) return;
		
		Optional<Unidade> unidadeOpcional = obterIdUnidade(scanner);

		if (unidadeOpcional == null || unidadeOpcional.get() == null) return;
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNomeFuncionario(nomeFuncioanrio);
		funcionario.setNrMatricula(nrMatricula);
		funcionario.setSalario(salario);
		funcionario.setDataContratacao(LocalDate.parse(dataContratacao, formatter));
		funcionario.setCargo(cargoOpcional.get());
		funcionario.setUnidade(unidadeOpcional.get());
		funcionarioRepository.save(funcionario);
		System.out.println("Salvo");
	}

	private Optional<Unidade> obterIdUnidade(Scanner scanner) {
		System.out.println("*** LISTAGEM DE UNIDADES *** ");
		List<Unidade> listaUni = (List<Unidade>) unidadeRepository.findAll();

		listaUni.forEach(System.out::println);

		System.out.println("Digite o Numero da Unidade entre as Listadas:");
		String codigoUnidade = scanner.next();

		Optional<Unidade> unidadeOpcional = unidadeRepository.findById(Integer.valueOf(codigoUnidade));

		if (unidadeOpcional == null) {
			System.out.println("Codigo da Unidade informada não existe ");
		}
		return unidadeOpcional;
	}

	private Optional<Cargo> obterIdCargo(Scanner scanner) {
		System.out.println("*** LISTAGEM DE CARGOS *** ");

		List<Cargo> lista = (List<Cargo>) cargoRepository.findAll();

		lista.forEach(System.out::println);

		System.out.println("Digite o numero do Cargo Entre os Listados: ");
		String codigoCargo = scanner.next();

		Optional<Cargo> cargoOpcional = cargoRepository.findById(Integer.valueOf(codigoCargo));

		if (cargoOpcional == null) {
			System.out.println("Codigo do Cargo informado não existe ");
		}
		return cargoOpcional;
	}

	public void atualizar(Scanner scanner) {
		System.out.println("Digite o codigo para atualizar");
		String codigo = scanner.next();

		Optional<Funcionario> funcionarioOpcional = funcionarioRepository.findById(Integer.valueOf(codigo));

		if (funcionarioOpcional == null) {
			System.out.println("Codigo do Funcionario informado não existe ");
			return;
		}

		System.out.println("Nome do Funcionario");
		String nomeFuncioanrio = scanner.next();
		System.out.println("Nr da Matricula");
		String nrMatricula = scanner.next();

		System.out.println("Nr Cargo");
		String codigoCargo = scanner.next();

		Optional<Cargo> cargoOpcional = cargoRepository.findById(Integer.valueOf(codigoCargo));

		if (cargoOpcional == null) {
			System.out.println("Codigo do Cargo informado não existe ");
			return;
		}

		System.out.println("Nr Unidade");
		String codigoUnidade = scanner.next();

		Optional<Unidade> unidadeOpcional = unidadeRepository.findById(Integer.valueOf(codigoUnidade));

		if (unidadeOpcional == null) {
			System.out.println("Codigo da Unidade informada não existe ");
			return;
		}

		Funcionario funcionario = funcionarioOpcional.get();

		funcionario.setNomeFuncionario(nomeFuncioanrio);
		funcionario.setNrMatricula(nrMatricula);
		funcionario.setCargo(cargoOpcional.get());
		funcionario.setUnidade(unidadeOpcional.get());

		System.out.println("Salvo");
	}

	public void visualizar(Scanner scanner) {
		System.out.println("Digite o codigo para Visualizar");
		String codigo = scanner.next();
		Optional<Funcionario> funcionarioOpcional = funcionarioRepository.findById(Integer.valueOf(codigo));

		if (funcionarioOpcional == null) {
			System.out.println("Codigo informado não existe ");
			return;
		}

		Funcionario funcionario = funcionarioOpcional.get();

		System.out.println("Nome do Funcionario " + funcionario.getNomeFuncionario());
		System.out.println("Nr Matricula " + funcionario.getNomeFuncionario());
		System.out.println("Cargo " + funcionario.getCargo().getDescricao());
		System.out.println("Unidade " + funcionario.getUnidade().getDescricao());

		System.out.println("Exibido");
	}

	public void visualizarTodos(Scanner scanner) {
		System.out.println("Qual a pagina ?");
		Integer pagina = scanner.nextInt();
		
		Pageable page = PageRequest.of(pagina, 15, Sort.unsorted());
		
		Page<Funcionario> lista = funcionarioRepository.findAll(page);

		if (lista == null || lista.getSize() == 0) {
			System.out.println("Nenhum funcionario encontrado ");
			return;
		}

		System.out.println("Listagem de Funcionarios");
		System.out.println("Pagina Atual "+lista.getNumber());
		System.out.println("Total de Elementos "+lista.getTotalElements());
		System.out.println("Total de Paginas "+lista.getTotalPages());
		
		lista.forEach(System.out::println);

				
		System.out.println("Exibido");
	}

	public void deletar(Scanner scanner) {
		System.out.println("Digite o codigo para remover");
		String codigo = scanner.next();
		Optional<Funcionario> funcionarioOpcional = funcionarioRepository.findById(Integer.valueOf(codigo));

		if (funcionarioOpcional == null) {
			System.out.println("Codigo informado não existe ");
			return;
		}

		Funcionario funcionario = funcionarioOpcional.get();

		funcionarioRepository.delete(funcionario);
		System.out.println("Removido");
	}

	public void buscarFuncionarioNome(Scanner scanner) {
		System.out.println("Qual o nome deseja Pesquisar ?");
		String nomeFuncionario = scanner.next();
		List<Funcionario> lista = funcionarioRepository.findByNomeFuncionario(nomeFuncionario);
		lista.forEach(System.out::println);
	}

}
