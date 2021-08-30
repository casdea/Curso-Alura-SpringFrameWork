package br.com.alura.spring.data.service;

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
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	private final CargoRepository cargoRepository;
	private boolean system = true;
	
	public CrudCargoService(CargoRepository cargoRepository)
	{
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner	scanner) {
		while (system) {
			System.out.println("Qual acao de cargo deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Excluir");
			System.out.println("5 - Exibir");
			
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

			default:
				system = false;
				break;
			}
			
		}

	}
	
	public void salvar(Scanner	scanner)
	{
		System.out.println("Descricao do Cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo");
	}

	public void atualizar(Scanner	scanner)
	{
		System.out.println("Digite o codigo para atualizar");
		String codigo = scanner.next();
		Optional<Cargo> cargoOpcional = cargoRepository.findById(Integer.valueOf(codigo));
		
		if (cargoOpcional==null) {
			System.out.println("Codigo informado não existe ");
			return; 
		}
		
		Cargo cargo = cargoOpcional.get();
		
		System.out.println("Digite a Descrição");
		String descricao = scanner.next();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo");
	}

	public void visualizar(Scanner	scanner)
	{
		
		System.out.println("Digite o codigo para Visualizar");
		String codigo = scanner.next();
		Optional<Cargo> cargoOpcional = cargoRepository.findById(Integer.valueOf(codigo));
		
		if (cargoOpcional==null) {
			System.out.println("Codigo informado não existe ");
			return; 
		}
		
		Cargo cargo = cargoOpcional.get();
		
		System.out.println("Descrição "+cargo.getDescricao());
		System.out.println("Exibido");
	}

	public void visualizarTodos(Scanner	scanner)
	{
		System.out.println("Qual a pagina ?");
		Integer pagina = scanner.nextInt();
		
		Pageable page = PageRequest.of(pagina, 15, Sort.unsorted());
		
		Page<Cargo> lista = cargoRepository.findAll(page);
		
		if (lista == null || lista.getSize() == 0) {
			System.out.println("Nenhum funcionario encontrado ");
			return;
		}

		System.out.println("Listagem de Funcionarios");
		System.out.println("Pagina Atual "+lista.getNumber());
		System.out.println("Total de Elementos "+lista.getTotalElements());
		System.out.println("Total de Paginas "+lista.getTotalPages());

		System.out.println("Listagem de Cargos");

		lista.forEach(System.out::println);
		
		System.out.println("Exibido");
	}

	public void deletar(Scanner	scanner)
	{
		System.out.println("Digite o codigo para remover");
		String codigo = scanner.next();
		Optional<Cargo> cargoOpcional = cargoRepository.findById(Integer.valueOf(codigo));
		
		if (cargoOpcional==null) {
			System.out.println("Codigo informado não existe ");
			return; 
		}
		
		Cargo cargo = cargoOpcional.get();
		
		cargoRepository.delete(cargo);
		System.out.println("Removido");
	}

	
}
