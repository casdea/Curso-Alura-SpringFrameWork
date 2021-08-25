import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsertParametros {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.open();

		System.out.println("Conectou");

		String nome = "JACA";
		String descricao = "SUCO DE JACA";
		
		Statement stm = connection.createStatement();
		stm.execute("INSERT INTO PRODUTO (NOME, DESCRICAO) Values ('"+nome+"','"+descricao+"')",
				Statement.RETURN_GENERATED_KEYS);

		ResultSet resultado = stm.getGeneratedKeys();

		while (resultado.next()) {
			Integer id = resultado.getInt(1);
			System.out.println("CHAVEV GERADA " + id);
		}

		System.out.println("FIM");

		connection.close();

	}

}
