package br.com.alura.gerenciador.model;

import java.util.Date;

public class Empresa {

	private Integer id;
	private String nome;
	private Date dataFundacao;

	public Empresa(Integer id, String nome, Date dataFundacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataFundacao = dataFundacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

}
