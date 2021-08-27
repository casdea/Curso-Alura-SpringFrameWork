package br.com.alura.cadastros;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.dao.GrupoProdutoDao;
import br.com.alura.modelo.GrupoProduto;
import br.com.alura.util.JPAUtil;

public class CadastroProdutoFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager em = JPAUtil.getEntityManager();
		
		GrupoProduto grupoProduto = new GrupoProduto("LIMAO");
		
		em.getTransaction().begin();
		em.persist(grupoProduto);

		em.flush();
		em.clear();

		GrupoProdutoDao grupoProdutoDao = new GrupoProdutoDao(em);
		
		GrupoProduto grupoFind = grupoProdutoDao.buscarPorId(grupoProduto.getId());
		System.out.println(grupoFind.getNomeGrupo());
		
		List<GrupoProduto> todos = grupoProdutoDao.buscarTodos();
		 
		todos.stream().forEach(grupoProdutoFindAll -> System.out.println("Find all "+grupoProdutoFindAll.getNomeGrupo()));

		todos = grupoProdutoDao.buscarPorNome("LIMAO");
		 
		todos.stream().forEach(grupoProdutoFindAll2 -> System.out.println("Find Por Nome "+grupoProdutoFindAll2.getNomeGrupo()));

	}

}
