package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Produto;

public class ProdutoDAO {

	private Connection connection;
	
	public ProdutoDAO(Connection connection) {
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

	public List<Produto> listar() throws SQLException {
		// TODO Auto-generated method stub
		try (PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO",
				Statement.RETURN_GENERATED_KEYS)) {

			stm.execute();

			try (ResultSet rs = stm.getResultSet()) {

				List<Produto> lista = new ArrayList<Produto>();
				
				while (rs.next()) {
					lista.add(new Produto(rs.getInt(1), rs.getString(2), rs.getString(2)));
				}
				
				return lista;
			}
		}
	}
}
