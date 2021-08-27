package br.com.alura.loja.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	private TipoEndereco tipoEndereco;
	private String logradouro;
	private String numero;
	private String cidade;
	private String bairro;
	private String perimetro;

	
	
	public Endereco() {
		super();
	}

	public Endereco(TipoEndereco tipoEndereco, String logradouro, String numero, String cidade, String bairro,
			String perimetro) {
		super();
		this.tipoEndereco = tipoEndereco;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.bairro = bairro;
		this.perimetro = perimetro;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getCidade() {
		return cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public String getPerimetro() {
		return perimetro;
	}

}
