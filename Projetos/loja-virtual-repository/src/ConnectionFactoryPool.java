import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**/
public class ConnectionFactoryPool {

	private DataSource dataSource;

	public ConnectionFactoryPool() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("sistema");
		comboPooledDataSource.setPassword("adm123%4-98lka9023");
		this.dataSource = comboPooledDataSource;

	}

	public Connection open() throws SQLException {
		return this.dataSource.getConnection();
	}

}
