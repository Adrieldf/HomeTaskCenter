package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaJDBC {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://motty.db.elephantsql.com:5432/bfrqpuzi";
		String user = "bfrqpuzi";
		String pwd = "Fm4za9rfWeSZgcRituCazF2eg8vCyJ1C";
		
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			
			System.out.println("Buscando os dados da tabela produto :\n");
			
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("select codigo, nome, descricao from produto order by codigo");

			while (rs.next()) {
				System.out.print(rs.getInt("codigo"));
				System.out.print(" ");
				System.out.print(rs.getString("nome"));
				System.out.print(" ");
				System.out.println(rs.getString("descricao"));
			}
		
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Não foi possível encontrar o driver JDBC");
		} catch (SQLException se) {
			System.out.println("Não foi possível conectar ao Banco de Dados");
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}	
}
