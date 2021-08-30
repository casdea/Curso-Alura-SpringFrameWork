package br.com.alura.spring.data.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.spring.data.orm.Funcionario;

public class SpecificationFuncionario {

	public static Specification<Funcionario> nomeFuncionario(String nomeFuncionario) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nomeFuncionario"),
				"%" + nomeFuncionario + "%");
	}

	public static Specification<Funcionario> nrMatricula(String nrMatricula) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nrMatricula"),
				"%" + nrMatricula + "%");
	}

	public static Specification<Funcionario> salario(Double salario) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("salario"),
				salario);
	}

}
