import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaExclusao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.open();

		System.out.println("Conectou");

		Statement stm = connection.createStatement();
		stm.execute("DELETE FROM PRODUTO WHERE ID >=2",
				Statement.RETURN_GENERATED_KEYS);

		Integer linhasExcluidas  = stm.getUpdateCount();
		
		System.out.println("LINHAS EXCLUIDAS "+linhasExcluidas);
		
		System.out.println("FIM");

		connection.close();

	}

}
