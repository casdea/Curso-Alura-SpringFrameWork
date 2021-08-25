import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**/
public class ConnectionFactory {
	
	public Connection open() throws SQLException
	{
		Connection connection =
				DriverManager.getConnection(
						"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
						"sistema","adm123%4-98lka9023");
		
		return connection;
	}
	
}
