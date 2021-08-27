package br.com.alura.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.modelo.GrupoProduto;

public class GrupoProdutoDao {
	private EntityManager em;

	public GrupoProdutoDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void cadastrar(GrupoProduto grupoProduto) {
		this.em.persist(grupoProduto);
	}
	
	public void atualizar(GrupoProduto grupoProduto) {
		this.em.merge(grupoProduto);
	}
	
	public void remover(GrupoProduto grupoProduto) {
		grupoProduto = this.em.merge(grupoProduto);
		this.em.remove(grupoProduto);
	}
	
	public GrupoProduto buscarPorId(Long id)
	{
		return em.find(GrupoProduto.class, id);
	}
	
	public List<GrupoProduto> buscarTodos()
	{
		return em.createQuery("SELECT g FROM GrupoProduto g", GrupoProduto.class).getResultList();
	}
	
	public List<GrupoProduto> buscarPorNome(String nome)
	{
		return em.createQuery("SELECT g FROM GrupoProduto g WHERE g.nomeGrupo =:nomeGrupo ", GrupoProduto.class)
				.setParameter("nomeGrupo", nome)
				.getResultList();
	}

	public List<GrupoProduto> buscarPorNomePorPosicao(String nome)
	{
		return em.createQuery("SELECT g FROM GrupoProduto g WHERE g.nomeGrupo =:? ", GrupoProduto.class)
				.setParameter(1, nome)
				.getResultList();
	}
}
