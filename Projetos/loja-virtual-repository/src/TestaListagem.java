import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {


	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection =
				DriverManager.getConnection(
						"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
						"sistema","adm123%4-98lka9023");
		System.out.println("Conectou");
		
		Statement stm = connection.createStatement();
		stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		
		ResultSet resultado = stm.getResultSet();
		
		while (resultado.next()) {
			Integer id = resultado.getInt("ID");
			String nome = resultado.getString("NOME");
			String descricao = resultado.getString("DESCRICAO");
			System.out.println("ID "+id+" NOME "+nome+" DESCRICAO "+descricao);
		}
		
		System.out.println("FIM");
		
		connection.close();		

	}

}
