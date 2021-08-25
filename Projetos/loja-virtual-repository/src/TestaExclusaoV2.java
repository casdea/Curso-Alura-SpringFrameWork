import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaExclusaoV2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.open();

		System.out.println("Conectou");

		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID >=?",
				Statement.RETURN_GENERATED_KEYS);

		stm.setInt(1, 2);
		stm.execute();
		
		Integer linhasExcluidas  = stm.getUpdateCount();
		
		System.out.println("LINHAS EXCLUIDAS "+linhasExcluidas);
		
		System.out.println("FIM");

		connection.close();

	}

}
