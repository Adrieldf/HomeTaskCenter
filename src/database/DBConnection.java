package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	protected static Connection conn;
	
	public static void main(String[] args) {
		GetConnection();
	}

	
	public static Connection GetConnection() {
		
		conn = null;
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://motty.db.elephantsql.com:5432/bfrqpuzi";
		String user = "bfrqpuzi";
		String pwd = "Fm4za9rfWeSZgcRituCazF2eg8vCyJ1C";
		
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			
			//insertProduct(conn, 100, "produto100", "descricao produto100");
			//updateProduct(conn, 100, "produtonovo", "produto massa");
			//getProducts(conn);
		System.out.println("Database Connected!");
		
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Não foi possível encontrar o driver JDBC");
			return null;
		} catch (SQLException se) {
			System.out.println("Não foi possível conectar ao Banco de Dados");
			return null;
		}
		
		return conn;
	}
	public static void CloseConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
