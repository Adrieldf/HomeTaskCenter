package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OccurrenceDAO;
import model.Occurrence;
import model.Task;

public class PostgresqlOccurrenceDB implements OccurrenceDAO {

	private Connection conn;

	public PostgresqlOccurrenceDB(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Occurrence> getAll(int idFamily) {
		List<Occurrence> occurrences = new ArrayList<Occurrence>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select * from occurrence where \"idFamily\" = ?");
			pstmt.setInt(1, idFamily);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Occurrence o = new Occurrence();
				
				o.setId(rs.getInt("id"));
				o.setIdFamily(rs.getInt("idFamily"));
				o.setIdTask(rs.getInt("idTask"));
				o.setDate(rs.getInt("date"));
				o.setHour(rs.getInt("hour"));
				occurrences.add(o);
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

		return occurrences;
	}

	@Override
	public Occurrence getById(int id, int idFamily) {
		List<Occurrence> occurrences = new ArrayList<Occurrence>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select * from occurrence where id = ? and \"idFamily\" = ?");
			pstmt.setInt(1, id);
			pstmt.setInt(2, idFamily);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Occurrence o = new Occurrence();
				
				o.setId(rs.getInt("id"));
				o.setIdFamily(rs.getInt("idFamily"));
				o.setIdTask(rs.getInt("idTask"));
				o.setDate(rs.getInt("date"));
				o.setHour(rs.getInt("hour"));
				occurrences.add(o);
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

		return occurrences.get(0);
	}

	@Override
	public void insert(Occurrence ocurrence) {
		if (ocurrence == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("insert into ocurrence (date, hour, \"idFamily\", \"idTask\") values ( ?, ?, ?, ?)");

			pstmt.setInt(1, ocurrence.getDate());
			pstmt.setInt(2, ocurrence.getHour());
			pstmt.setInt(3, ocurrence.getIdFamily());
			pstmt.setInt(4, ocurrence.getIdTask());

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
	public void remove(Occurrence ocurrence) {
		if (ocurrence == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("delete from ocurrence where id = ? and \"idFamily\" = ?");
			pstmt.setInt(1, ocurrence.getId());
			pstmt.setInt(2, ocurrence.getIdFamily());
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
	public void edit(Occurrence ocurrence) {
		if (ocurrence == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("update ocurrence set date = ?, hour = ? where id = ? and \"idFamily\" = ?");

			pstmt.setInt(1, ocurrence.getDate());
			pstmt.setInt(2, ocurrence.getHour());
			pstmt.setInt(3, ocurrence.getId());
			pstmt.setInt(4, ocurrence.getIdFamily());

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
