package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Produto;

public class CategoriaDAO {

	private Connection connection;
	
	public CategoriaDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	public void salvarCategoria(Categoria categoria) throws SQLException {

		try (PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (NOME) Values (?)",
				Statement.RETURN_GENERATED_KEYS)) {

			stm.setString(1, categoria.getNome());

			stm.execute();

			try (ResultSet resultado = stm.getGeneratedKeys()) {

				while (resultado.next()) {
					Integer id = resultado.getInt(1);
					System.out.println("CHAVEV GERADA " + id);
				}
			}
		}
	}

	public List<Categoria> listar() throws SQLException {
		// TODO Auto-generated method stub
		try (PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME FROM CATEGORIA",
				Statement.RETURN_GENERATED_KEYS)) {

			stm.execute();

			try (ResultSet rs = stm.getResultSet()) {

				List<Categoria> lista = new ArrayList<Categoria>();
				
				while (rs.next()) {
					lista.add(new Categoria(rs.getInt(1), rs.getString(2)));
				}
				
				return lista;
			}
		}
	}
}
