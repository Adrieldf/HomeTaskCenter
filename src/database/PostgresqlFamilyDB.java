package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.FamilyDAO;
import model.Family;

public class PostgresqlFamilyDB implements FamilyDAO {

	private Connection conn;

	public PostgresqlFamilyDB(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Family> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Family> families = new ArrayList<Family>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select id, name from family order by id");

			while (rs.next()) {
				families.add(new Family(rs.getInt("id"), rs.getString("name")));
			}

		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro : " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return families;
	}

	@Override
	public Family getById(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Family family = new Family();
		try {
			pstmt = conn.prepareStatement("select id, name from family where id = ? order by id");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			family = new Family(rs.getInt("id"), rs.getString("name"));

		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro : " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return family;
	}

	@Override
	public void insert(Family family) {
		if (family == null) {
			return;
		}
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("insert into family(name) values ( ? )");

			pstmt.setString(1, family.getName());
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

	@Override
	public void remove(Family family) {
		if (family == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("delete from family where id = ?");
			pstmt.setInt(1, family.getId());
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
	public void edit(Family family) {
		if (family == null) {
			return;
		}
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("update family set name = ? where id = ? ");
			pstmt.setString(1, family.getName());
			pstmt.setInt(2, family.getId());
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
