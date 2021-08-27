package br.com.alura.loja.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	@Embedded
	private Endereco endereco;

	public Cliente(String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Cliente(String nome, String cpf, TipoEndereco tipoEndereco, String logradouro, String numero, String cidade,
			String bairro, String perimetro) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = new Endereco(tipoEndereco, logradouro, numero, cidade, bairro, perimetro);
	}

	public Cliente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
