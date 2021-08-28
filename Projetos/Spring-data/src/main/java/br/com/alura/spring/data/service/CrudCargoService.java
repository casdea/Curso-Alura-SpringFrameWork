package br.com.alura.spring.data.service;

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

}
