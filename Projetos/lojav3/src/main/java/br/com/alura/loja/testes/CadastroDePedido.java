package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDePedido {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();

		Pedido pedido = new Pedido(criarCliente(em));
		pedido.adicionarItem(new ItemPedido(10, pedido, criarProduto(em, criarCategoria(em)) ));

		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);

		em.getTransaction().commit();
	}

	private static void popularBancoDeDados() {

		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();

		em.getTransaction().commit();
		em.close();
	}

	public static Cliente criarCliente(EntityManager em) {
		Cliente cliente = new Cliente("Rodrigo", "123456");

		ClienteDao clienteDao = new ClienteDao(em);
		clienteDao.cadastrar(cliente);

		return cliente;
	}

	public static Categoria criarCategoria(EntityManager em) {
		Categoria celulares = new Categoria("CELULARES");
		CategoriaDao categoriaDao = new CategoriaDao(em);
		categoriaDao.cadastrar(celulares);
		return celulares;
	}

	public static Produto criarProduto(EntityManager em, Categoria categoria) {
		Produto produto = new Produto("Bicicleta", "Caloi", new BigDecimal("800"), categoria);
		ProdutoDao produtoDao = new ProdutoDao(em);

		produtoDao.cadastrar(produto);
		
		return produto;
	}

}
