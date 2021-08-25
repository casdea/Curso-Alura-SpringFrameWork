import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsertParametrosV2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.open();

		System.out.println("Conectou");

		String nome = "JACA";
		String descricao = "SUCO DE JACA";
		
		PreparedStatement stm = connection.prepareStatement(
				"INSERT INTO PRODUTO (NOME, DESCRICAO) Values (?, ?)",
				Statement.RETURN_GENERATED_KEYS);

		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		ResultSet resultado = stm.getGeneratedKeys();

		while (resultado.next()) {
			Integer id = resultado.getInt(1);
			System.out.println("CHAVEV GERADA " + id);
		}

		System.out.println("FIM");

		connection.close();

	}

}
