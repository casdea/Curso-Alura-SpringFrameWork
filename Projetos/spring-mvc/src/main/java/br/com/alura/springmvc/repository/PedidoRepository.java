package br.com.alura.springmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springmvc.model.Pedido;
import br.com.alura.springmvc.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	public List<Pedido> findByStatusPedido(StatusPedido statusPedido);
}
