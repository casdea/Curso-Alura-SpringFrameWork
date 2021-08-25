import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaListagem {


	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection =
				DriverManager.getConnection(
						"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
						"sistema","adm123%4-98lka9023");
		System.out.println("Conectou");
		
		connection.close();		

	}

}
