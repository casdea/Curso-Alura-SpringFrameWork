import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ProdutoDAO;
import modelo.Produto;

public class TestaInsertProdutoEListagemProdutoV6 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Connection connection = new ConnectionFactory().open();

		connection.setAutoCommit(false);

		System.out.println("Conectou");

		try {

			Produto produto = new Produto("COMODA", "COMODA VERTICAL");

			new ProdutoDAO(connection).salvarProduto(produto);
			
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
