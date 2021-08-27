package br.com.alura.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.modelo.Produto;

public class ProdutoDao {
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	public Produto buscarPorId(Long id)
	{
		return em.find(Produto.class, id);
	}
	
	public List<Produto> buscarTodos(Long id)
	{
		return em.createNamedQuery("SELECT P FROM PRODUTO p", Produto.class).getResultList();
	}

	public List<Produto> buscarPorGrupoProduto(String nomeCategoria)
	{
		return em.createQuery("SELECT p FROM Produto p WHERE p.grupoProduto.nomeGrupo like :nomeGrupo", Produto.class)
				.setParameter("nomeGrupo", nomeCategoria)				
				.getResultList();
	}

	public BigDecimal buscarPrecoProdutoPorNome(String nomeProduto)
	{
		return em.createQuery("SELECT p.preco FROM Produto p WHERE p.nome like :nome", BigDecimal.class)
				.setParameter("nome", nomeProduto)				
				.getSingleResult();
	}

}
