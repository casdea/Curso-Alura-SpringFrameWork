import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsertParametrosV3 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.open();
		connection.setAutoCommit(false);

		System.out.println("Conectou");

		try {

			PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (NOME, DESCRICAO) Values (?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			adicionarRegistro("RADIO", "RADIO GM", stm);
			adicionarRegistro("RELOGIO", "RELOGIO", stm);
			connection.commit();
			
			System.out.println("FIM");

			stm.close();;
			connection.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			connection.rollback();
			System.out.println("ROLLBACK "+e.getMessage());
		}

	}

	private static void adicionarRegistro(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		ResultSet resultado = stm.getGeneratedKeys();

		while (resultado.next()) {
			Integer id = resultado.getInt(1);
			System.out.println("CHAVEV GERADA " + id);
		}
		
		
	}

}
