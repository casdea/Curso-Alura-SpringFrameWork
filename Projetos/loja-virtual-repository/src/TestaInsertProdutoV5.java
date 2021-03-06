import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.ProdutoDAO;
import modelo.Produto;

public class TestaInsertProdutoV5 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Connection connection = new ConnectionFactory().open();

		connection.setAutoCommit(false);

		System.out.println("Conectou");

		try {

			Produto produto = new Produto("NOVO", "NOVA VERTICAL");

			ProdutoDAO produtoDAO =  new ProdutoDAO(connection);
			
			produtoDAO.salvarProduto(produto);
			
			List<Produto> listaProdutos = produtoDAO.listar();
			listaProdutos.stream().forEach(x -> System.out.println(x.toString()));
			
			connection.commit();

			System.out.println("FIM");

			connection.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			connection.rollback();
			System.out.println("ROLLBACK " + e.getMessage());
		}

	}

	private static void adicionarRegistro(Produto produto, PreparedStatement stm) throws SQLException {
		stm.setString(1, produto.getNome());
		stm.setString(2, produto.getDescricao());

		stm.execute();

		ResultSet resultado = stm.getGeneratedKeys();

		while (resultado.next()) {
			Integer id = resultado.getInt(1);
			System.out.println("CHAVEV GERADA " + id);
		}

	}

}
