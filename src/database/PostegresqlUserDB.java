package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import model.User;

public class PostegresqlUserDB implements UserDAO {
	
	private Connection conn;

	public PostegresqlUserDB(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public List<User> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select id, name, password, \"idFamily\" from user order by id");
			
			while (rs.next()) {
				users.add(new User(rs.getInt("id"),rs.getString("name"),rs.getString("password"),rs.getInt("idFamily")));
			}
			
		}catch(SQLException ex) {
			System.out.println("Ocorreu um erro : " + ex.getMessage());
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
	@Override
	public User getById(int id, int idFamily) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		try {
			pstmt = conn.prepareStatement("select id, name, password, \"idFamily\" from user where id = ? and \"idFamily\" = ? order by id");
			pstmt.setInt(1, id);
			pstmt.setInt(2, idFamily);
			rs = pstmt.executeQuery();
			
			user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("password"),rs.getInt("idFamily"));
		
			
		}catch(SQLException ex) {
			System.out.println("Ocorreu um erro : " + ex.getMessage());
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
	@Override
	public void insert(User user) {
		if (user == null) {
			return;
		}
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("insert into user(name, password) values ( ? , ? )");
		
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.executeUpdate();
		}
		catch(SQLException ex) {
			System.out.println("Ocorreu um erro : " + ex.getMessage());
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
	@Override
	public void remove(User user) {
		if (user == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("delete from user where id = ?");
			pstmt.setInt(1, user.getId());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println("Ocorreu um erro : " + se.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	@Override
	public void edit(User user) {
		if (user == null) {
			return;
		}
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("update user set name = ?, password = ? where id = ? and \"idFamily\" = ? ");
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getId());
			pstmt.setInt(4, user.getIdFamily());
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro : " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}
}
