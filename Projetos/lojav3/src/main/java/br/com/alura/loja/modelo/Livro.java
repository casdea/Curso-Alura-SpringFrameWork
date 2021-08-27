package br.com.alura.loja.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("L")
public class Livro extends Produto {

	private String autor;
	private Integer numeroPagina;

	public Livro() {
		super();
	}

	public Livro(String autor, Integer numeroPagina) {
		super();
		this.autor = autor;
		this.numeroPagina = numeroPagina;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getNumeroPagina() {
		return numeroPagina;
	}

	public void setNumeroPagina(Integer numeroPagina) {
		this.numeroPagina = numeroPagina;
	}

}
