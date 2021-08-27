package br.com.alura.cadastros;

import javax.persistence.EntityManager;

import br.com.alura.modelo.GrupoProduto;
import br.com.alura.util.JPAUtil;

public class CadastroProdutoUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager em = JPAUtil.getEntityManager();
		
		GrupoProduto grupoProduto = new GrupoProduto("MOUSE");
		
		em.getTransaction().begin();
		em.persist(grupoProduto);

		em.flush();
		em.clear();
		
		grupoProduto = em.merge(grupoProduto);
		em.persist(grupoProduto);
		em.flush();
		em.clear();
		
		em.remove(grupoProduto);
		em.flush();
	}

}
