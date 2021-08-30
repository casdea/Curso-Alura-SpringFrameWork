package br.com.alura.spring.data.orm;

public class FuncionarioProjecaoClasseDto {

	private Integer id;
	private String nomeFuncionario;
	private Double salario;

	public FuncionarioProjecaoClasseDto(Integer id, String nomeFuncionario, Double salario) {
		super();
		this.id = id;
		this.nomeFuncionario = nomeFuncionario;
		this.salario = salario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

}
