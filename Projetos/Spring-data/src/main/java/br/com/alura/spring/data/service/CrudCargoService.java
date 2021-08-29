package br.com.alura.spring.data.service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	private final CargoRepository cargoRepository;
	
	public CrudCargoService(CargoRepository cargoRepository)
	{
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner	scanner) {
		
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
		List<Cargo> lista = (List<Cargo>) cargoRepository.findAll();
		
		if (lista==null || lista.size()==0) {
			System.out.println("Nenhum cargo encontrado ");
			return; 
		}

		System.out.println("Listagem de Cargos");
		
		for (Cargo cargo : lista) {
			System.out.println("Descrição "+cargo.getDescricao());
		}
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
