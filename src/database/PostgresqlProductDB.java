package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;
import model.Category;
import model.Product;

public class PostgresqlProductDB implements ProductDAO {

	private Connection conn;

	public PostgresqlProductDB(Connection conn) {
		this.conn = conn;
	}

	public PostgresqlProductDB() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public List<Product> getAll(int idFamily) {
		List<Product> products = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select * from product where \"idFamily\" = ?");
			pstmt.setInt(1, idFamily);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product p = new Product(rs.getInt("id"), rs.getString("nome"), rs.getInt("idCategory"), rs.getInt("idFamily"));

				products.add(p);
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

		return products;
	}

	@Override
	public List<Product> getById(int id, int idFamily) {
		List<Product> products = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select * from product where id = ? and \"idFamily\" = ?");
			pstmt.setInt(1, id);
			pstmt.setInt(2, idFamily);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("idCategory"), rs.getInt("idFamily"));
				products.add(p);
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

		return products;
	}

	@Override
	public void insert(Product product) {
		if (product == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("insert into product (name, \"idCategory\", \"idFamily\") values (?,?,?)");

			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getIdCategory());
			pstmt.setInt(3, product.getIdFamily());

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
	public void remove(Product product) {
		if (product == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("delete from product where id = ? and \"idFamily\" = ?");
			pstmt.setInt(1, product.getId());
			pstmt.setInt(2, product.getIdFamily());
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
	public void edit(Product product) {
		if (product == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("update category set name = ?, \"idCategory\" = ? where id = ? and \"idFamily\" = ?");

			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getIdCategory());
			pstmt.setInt(3, product.getId());
			pstmt.setInt(4, product.getIdFamily());

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
