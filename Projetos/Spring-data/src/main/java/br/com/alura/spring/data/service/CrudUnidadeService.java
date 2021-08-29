package br.com.alura.spring.data.service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Unidade;
import br.com.alura.spring.data.repository.UnidadeRepository;

@Service
public class CrudUnidadeService {

	private final UnidadeRepository unidadeRepository;
	private boolean system = true;

	public CrudUnidadeService(UnidadeRepository unidadeRepository) {
		this.unidadeRepository = unidadeRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao de unidade deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar ");
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

	public void salvar(Scanner scanner) {
		System.out.println("Descricao da Unidade");
		String descricao = scanner.next();
		Unidade unidade = new Unidade();
		unidade.setDescricao(descricao);
		unidadeRepository.save(unidade);
		System.out.println("Salvo");
	}

	public void atualizar(Scanner scanner) {
		System.out.println("Digite o codigo para atualizar");
		String codigo = scanner.next();
		Optional<Unidade> unidadeOpcional = unidadeRepository.findById(Integer.valueOf(codigo));

		if (unidadeOpcional == null) {
			System.out.println("Codigo informado não existe ");
			return;
		}

		Unidade unidade = unidadeOpcional.get();

		System.out.println("Digite a Descrição");
		String descricao = scanner.next();
		unidade.setDescricao(descricao);
		unidadeRepository.save(unidade);
		System.out.println("Salvo");
	}

	public void visualizar(Scanner scanner) {
		System.out.println("Digite o codigo para Visualizar");
		String codigo = scanner.next();
		Optional<Unidade> unidadeOpcional = unidadeRepository.findById(Integer.valueOf(codigo));

		if (unidadeOpcional == null) {
			System.out.println("Codigo informado não existe ");
			return;
		}

		Unidade unidade = unidadeOpcional.get();

		System.out.println("Descrição " + unidade.getDescricao());
		System.out.println("Exibido");
	}

	public void visualizarTodos(Scanner scanner) {
		List<Unidade> lista = (List<Unidade>) unidadeRepository.findAll();

		if (lista == null || lista.size() == 0) {
			System.out.println("Nenhuma unidade encontrada ");
			return;
		}

		System.out.println("Listagem de Unidades");

		lista.stream().forEach(unidade -> System.out.println("Unidade "+unidade.getDescricao()));
		System.out.println("Exibido");
	}

	public void deletar(Scanner scanner) {
		System.out.println("Digite o codigo para remover");
		String codigo = scanner.next();
		Optional<Unidade> unidadeOpcional = unidadeRepository.findById(Integer.valueOf(codigo));

		if (unidadeOpcional == null) {
			System.out.println("Codigo informado não existe ");
			return;
		}

		Unidade unidade = unidadeOpcional.get();

		unidadeRepository.delete(unidade);
		System.out.println("Removido");
	}

}
