package br.com.alura.cadastros;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.dao.GrupoProdutoDao;
import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.GrupoProduto;
import br.com.alura.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class CadastroProdutoInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin(); 

		GrupoProduto grupoProduto = new GrupoProduto("CABOS");

		GrupoProdutoDao grupoProdutoDao = new GrupoProdutoDao(em);

		grupoProdutoDao.cadastrar(grupoProduto);

		Produto produto = new Produto("BICILETA", "BICICLETA CALOI", new BigDecimal("1200.00"), Categoria.CADEIRA, grupoProduto);

		ProdutoDao produtoDao = new ProdutoDao(em);

		produtoDao.cadastrar(produto);
		em.getTransaction().commit();
	
		em.getTransaction().begin(); 
		produto.setDescricao("DE NOVO");
		//em.merge(produto);
		em.getTransaction().commit();
		
		Produto produtox = em.find(Produto.class, produto.getId());
		
		System.out.println(produtox.getDescricao());
	
		List<Produto> lista = produtoDao.buscarPorGrupoProduto("CABOS%");
		lista.stream().forEach(p -> System.out.println(p.getGrupoProduto().getNomeGrupo()));
		
		System.out.println(produtoDao.buscarPrecoProdutoPorNome("BICILETA%")); 
		//lista.stream().map().forEach(System.out::println);
	}

}
