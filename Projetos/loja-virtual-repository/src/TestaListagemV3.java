import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagemV3 {


	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection  connection = connectionFactory.open();		
		
		System.out.println("Conectou");
		
		PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		
		
		stm.execute();
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
