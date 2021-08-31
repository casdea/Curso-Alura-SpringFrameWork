package br.com.alura.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springmvc.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
