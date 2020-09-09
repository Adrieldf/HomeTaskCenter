package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaJDBC {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		
		
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://motty.db.elephantsql.com:5432/bfrqpuzi";
		String user = "bfrqpuzi";
		String pwd = "Fm4za9rfWeSZgcRituCazF2eg8vCyJ1C";
		
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			
			//insertProduct(conn, 100, "produto100", "descricao produto100");
			//updateProduct(conn, 100, "produtonovo", "produto massa");
			getProducts(conn);
		
		
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Não foi possível encontrar o driver JDBC");
		} catch (SQLException se) {
			System.out.println("Não foi possível conectar ao Banco de Dados");
		} finally {
			try {
				
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void getProducts(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select codigo, nome, descricao from produto order by codigo");
			
			while (rs.next()) {
				System.out.print(rs.getInt("codigo"));
				System.out.print(" ");
				System.out.print(rs.getString("nome"));
				System.out.print(" ");
				System.out.println(rs.getString("descricao"));
			}
			
		}catch(SQLException ex) {
			System.out.println("Error while getting Products");
			ex.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public static void insertProduct(Connection conn, int id, String name, String description) {
	
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement("insert into produto(codigo, nome, descricao) values ( ? , ? , ? )");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, description);
			pstmt.executeUpdate();
		}
		catch(SQLException ex) {
			System.out.println("Error while inserting Product");
			ex.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}
	
	public static void updateProduct(Connection conn, int id, String name, String description) {
		
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement("update produto set nome = ?, descricao = ? where codigo = ?");
			pstmt.setString(1, name);
			pstmt.setString(2, description);	
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
			
		}
		catch(SQLException ex) {
			System.out.println("Error while updating Product");
			ex.printStackTrace();
		}
		finally {
			
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
}
