package br.com.alura.springmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.springmvc.model.Pedido;
import br.com.alura.springmvc.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	List<Pedido> findByStatus(StatusPedido status);
	
	@Query("SELECT p FROM Pedido p Join p.user u where u.username = :username ")
	List<Pedido> findAllByUsuario(@Param("username") String username);
	
	List<Pedido> findByStatusAndUserUsername(StatusPedido status, String username);
	

}
