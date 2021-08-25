import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Produto;

public class PersistenciaProduto {

	private Connection connection;
	
	public PersistenciaProduto(Connection connection) {
		super();
		this.connection = connection;
	}

	public void salvarProduto(Produto produto) throws SQLException {

		try (PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) Values (?, ?)",
				Statement.RETURN_GENERATED_KEYS)) {

			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());

			stm.execute();

			try (ResultSet resultado = stm.getGeneratedKeys()) {

				while (resultado.next()) {
					Integer id = resultado.getInt(1);
					System.out.println("CHAVEV GERADA " + id);
				}
			}
		}
	}
}
