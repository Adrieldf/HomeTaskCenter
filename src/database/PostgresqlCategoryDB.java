package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryDAO;
import model.Category;

public class PostgresqlCategoryDB implements CategoryDAO {

	private Connection conn;

	public PostgresqlCategoryDB(Connection conn) {
		this.conn = conn;
	}
	
	public PostgresqlCategoryDB() {

	}

	@Override
	public List<Category> getAll(int idFamily) {
		List<Category> categories = new ArrayList<Category>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select * from category where \"idFamily\" = ?");
			pstmt.setInt(1, idFamily);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setIdFamily(rs.getInt("idFamily"));
				categories.add(c);
			}

		} catch (SQLException se) {
			System.out.println("Ocorreu um erro : " + se.getMessage());
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return categories;
	}

	@Override
	public List<Category> getById(int id, int idFamily) {
		List<Category> categories = new ArrayList<Category>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select * from category where id = ? and \"idFamily\" = ?");
			pstmt.setInt(1, id);
			pstmt.setInt(2, idFamily);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setIdFamily(rs.getInt("idFamily"));
				categories.add(c);
			}

		} catch (SQLException se) {
			System.out.println("Ocorreu um erro : " + se.getMessage());
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return categories;
	}

	@Override
	public void insert(Category category) {
		if (category == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("insert into category (name, \"idFamily\") values (?,?)");

			pstmt.setString(1, category.getName());
			if(category.getIdFamily()!=null) {
				pstmt.setInt(2, category.getIdFamily());
			}
			
			
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
	public void remove(Category category) {
		if (category == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("delete from category where id = ? and \"idFamily\" = ?");
			pstmt.setInt(1, category.getId());
			pstmt.setInt(2, category.getIdFamily());
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
	public void edit(Category category) {
		if (category == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("update category set name = ? where id = ? and \"idFamily\" = ?");

			pstmt.setString(1, category.getName());
			pstmt.setInt(2, category.getId());
			pstmt.setInt(3, category.getIdFamily());

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

}
