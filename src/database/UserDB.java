package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDB {

	public static List<User> GetUsers(Connection conn){
		Statement stmt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select id, name, password from user order by id");
			
			while (rs.next()) {
				users.add(new User(rs.getInt("id"),rs.getString("name"),rs.getString("password")));
			}
			
		}catch(SQLException ex) {
			System.out.println("Erro ao procurar os produtos");
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
		
		return users;
		
	}
	public static User GetUser(Connection conn, int id){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		try {
			pstmt = conn.prepareStatement("select id, name, password from user where id = ? order by id");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("password"));
		
			
		}catch(SQLException ex) {
			System.out.println("Erro ao procurar os produtos");
			ex.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return user;
		
	}
	public static void InsertUser(Connection conn, int id, String name, String password) {
		PreparedStatement pstmt = null;
		try {
			//aqui tem que pegar o ultimo id e adicionar mais um, caso ele seja 0
			pstmt = conn.prepareStatement("insert into user(id, name, password) values ( ? , ? , ? )");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.executeUpdate();
		}
		catch(SQLException ex) {
			System.out.println("Erro ao inserir usuário");
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
	public static void UpdateUser(Connection conn, int id, String name, String password) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("update user set name = ?, password = ? where id = ?");
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
		}
		catch(SQLException ex) {
			System.out.println("Erro ao atualizar usuário");
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
