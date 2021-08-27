package br.com.alura.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GrupoProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomeGrupo;

	public GrupoProduto() {
		super();
	}

	public GrupoProduto(String nomeGrupo) {
		super();
		this.nomeGrupo = nomeGrupo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

}
