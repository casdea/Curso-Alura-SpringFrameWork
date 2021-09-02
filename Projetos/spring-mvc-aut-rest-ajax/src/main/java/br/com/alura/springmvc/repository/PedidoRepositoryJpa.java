package br.com.alura.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.alura.springmvc.model.Pedido;

@Repository
public class PedidoRepositoryJpa {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Pedido> findAll() {
		Query query = entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class);

		return query.getResultList();
	}

}
