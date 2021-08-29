package br.com.alura.spring.data.service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.Unidade;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.repository.UnidadeRepository;

@Service
public class CrudFuncionarioService {
	
	private final FuncionarioRepository funcionarioRepository;
	private final UnidadeRepository unidadeRepository;
	private final CargoRepository cargoRepository;
	
	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository, UnidadeRepository unidadeRepository)
	{
		this.funcionarioRepository = funcionarioRepository;
		this.cargoRepository = cargoRepository;
		this.unidadeRepository = unidadeRepository;
	}
	
	public void inicial(Scanner	scanner) {
		
	}
	
	public void salvar(Scanner	scanner)
	{
		System.out.println("Nome do Funcionario");
		String nomeFuncioanrio = scanner.next();
		System.out.println("Nr da Matricula");
		String nrMatricula  = scanner.next();

		System.out.println("Nr Cargo");
		String codigoCargo = scanner.next();

		Optional<Cargo> cargoOpcional = cargoRepository.findById(Integer.valueOf(codigoCargo));
		
		if (cargoOpcional==null) {
			System.out.println("Codigo do Cargo informado não existe ");
			return; 
		}

		System.out.println("Nr Unidade");
		String codigoUnidade = scanner.next();


		Optional<Unidade> unidadeOpcional = unidadeRepository.findById(Integer.valueOf(codigoUnidade));
		
		if (unidadeOpcional==null) {
			System.out.println("Codigo da Unidade informada não existe ");
			return; 
		}

		
		Funcionario funcionario = new Funcionario();
		funcionario.setNomeFuncionario(nomeFuncioanrio);
		funcionario.setNrMatricula(nrMatricula);
		funcionario.setCargo(cargoOpcional.get());
		funcionario.setUnidade(unidadeOpcional.get());
		
		funcionarioRepository.save(funcionario);
		System.out.println("Salvo");
	}

	public void atualizar(Scanner	scanner)
	{
		System.out.println("Digite o codigo para atualizar");
		String codigo = scanner.next();

		Optional<Funcionario> funcionarioOpcional = funcionarioRepository.findById(Integer.valueOf(codigo));
		
		if (funcionarioOpcional==null) {
			System.out.println("Codigo do Funcionario informado não existe ");
			return; 
		}
		
		System.out.println("Nome do Funcionario");
		String nomeFuncioanrio = scanner.next();
		System.out.println("Nr da Matricula");
		String nrMatricula  = scanner.next();

		System.out.println("Nr Cargo");
		String codigoCargo = scanner.next();

		Optional<Cargo> cargoOpcional = cargoRepository.findById(Integer.valueOf(codigoCargo));
		
		if (cargoOpcional==null) {
			System.out.println("Codigo do Cargo informado não existe ");
			return; 
		}

		System.out.println("Nr Unidade");
		String codigoUnidade = scanner.next();


		Optional<Unidade> unidadeOpcional = unidadeRepository.findById(Integer.valueOf(codigoUnidade));
		
		if (unidadeOpcional==null) {
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

	public void visualizar(Scanner	scanner)
	{
		System.out.println("Digite o codigo para Visualizar");
		String codigo = scanner.next();
		Optional<Funcionario> funcionarioOpcional = funcionarioRepository.findById(Integer.valueOf(codigo));
		
		if (funcionarioOpcional==null) {
			System.out.println("Codigo informado não existe ");
			return; 
		}
		
		Funcionario funcionario = funcionarioOpcional.get();
		
		System.out.println("Nome do Funcionario "+funcionario.getNomeFuncionario());
		System.out.println("Nr Matricula "+funcionario.getNomeFuncionario());
		System.out.println("Cargo "+funcionario.getCargo().getDescricao());
		System.out.println("Unidade "+funcionario.getUnidade().getDescricao());
		
		System.out.println("Exibido");
	}

	public void visualizarTodos(Scanner	scanner)
	{
		List<Funcionario> lista = (List<Funcionario>) funcionarioRepository.findAll();
		
		if (lista==null || lista.size()==0) {
			System.out.println("Nenhum funcionario encontrado ");
			return; 
		}

		System.out.println("Listagem de Funcionarios");
		
		for (Funcionario funcionario : lista) {
			System.out.println("Nome do Funcionario "+funcionario.getNomeFuncionario());
			System.out.println("Nr Matricula "+funcionario.getNomeFuncionario());
			System.out.println("Cargo "+funcionario.getCargo().getDescricao());
			System.out.println("Unidade "+funcionario.getUnidade().getDescricao());
		}
		System.out.println("Exibido");
	}

	public void deletar(Scanner	scanner)
	{
		System.out.println("Digite o codigo para remover");
		String codigo = scanner.next();
		Optional<Funcionario> funcionarioOpcional = funcionarioRepository.findById(Integer.valueOf(codigo));
		
		if (funcionarioOpcional==null) {
			System.out.println("Codigo informado não existe ");
			return; 
		}
		
		Funcionario funcionario = funcionarioOpcional.get();
		
		funcionarioRepository.delete(funcionario);
		System.out.println("Removido");
	}

	
}
