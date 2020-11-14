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
	public List<Occurrence> getAll( int idTask,int idFamily) {
		List<Occurrence> occurrences = new ArrayList<Occurrence>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select * from occurrence where \"idTask\" = ? and \"idFamily\" = ?");
			pstmt.setInt(1, idTask);
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

		return occurrences;
	}

	@Override
	public Occurrence getById(int id, int idTask, int idFamily) {
		List<Occurrence> occurrences = new ArrayList<Occurrence>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select * from occurrence where id = ? and \"idTask\" = ? and \"idFamily\" = ?");
			pstmt.setInt(1, id);
			pstmt.setInt(2, idTask);
			pstmt.setInt(3, idFamily);
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
	public int getMaxId(int idFamily, int idTask) {
		int maxId = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select MAX (id) from occurrence where \"idFamily\" = ? and \"idTask\" = ?");
		
			pstmt.setInt(1, idFamily);
			pstmt.setInt(2, idTask);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				maxId = rs.getInt("max");
				
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

		return maxId;
		
	}
	
	@Override
	public void insert(Occurrence occurrence) {
		if (occurrence == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("insert into occurrence (date, hour, \"idFamily\", \"idTask\") values ( ?, ?, ?, ?)");

			pstmt.setInt(1, occurrence.getDate());
			pstmt.setInt(2, occurrence.getHour());
			pstmt.setInt(3, occurrence.getIdFamily());
			pstmt.setInt(4, occurrence.getIdTask());

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
	public void remove(Occurrence occurrence) {
		if (occurrence == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("delete from occurrence where id = ? and \"idTask\" = ? and \"idFamily\" = ?");
			pstmt.setInt(1, occurrence.getId());
			pstmt.setInt(2, occurrence.getIdTask());
			pstmt.setInt(3, occurrence.getIdFamily());
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
	public void edit(Occurrence occurrence) {
		if (occurrence == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("update occurrence set date = ?, hour = ? where id = ? and \"idTask\" = ? and \"idFamily\" = ?");

			pstmt.setInt(1, occurrence.getDate());
			pstmt.setInt(2, occurrence.getHour());
			pstmt.setInt(3, occurrence.getId());
			pstmt.setInt(4, occurrence.getIdTask());
			pstmt.setInt(5, occurrence.getIdFamily());

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
