package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ReminderDAO;
import model.Occurrence;
import model.Reminder;

public class PostgresqlReminderDB implements ReminderDAO {

	private Connection conn;

	public PostgresqlReminderDB(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Reminder> getAll(int idTask, int idOccurrence, int idFamily) {
		List<Reminder> reminders = new ArrayList<Reminder>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select * from reminder where \"idTask\" = ? and \"idOccurrence\" = ? and \"idFamily\" = ?");

			pstmt.setInt(1, idTask);
			pstmt.setInt(2, idOccurrence);
			pstmt.setInt(3, idFamily);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Reminder r = new Reminder();
				
				r.setId(rs.getInt("id"));
				r.setIdFamily(rs.getInt("idFamily"));
				r.setIdTask(rs.getInt("idTask"));
				r.setIdOccurrence(rs.getInt("idOccurrence"));
				r.setTitle(rs.getString("title"));
				r.setDescription(rs.getString("description"));
				reminders.add(r);
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

		return reminders;
	}

	@Override
	public Reminder getById(int id, int idTask, int idOccurrence, int idFamily) {
		List<Reminder> reminders = new ArrayList<Reminder>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select * from reminder where id = ? and \"idTask\" = ? and \"idOccurrence\" = ? and \"idFamily\" = ?");

			pstmt.setInt(1, id);
			pstmt.setInt(2, idTask);
			pstmt.setInt(3, idOccurrence);
			pstmt.setInt(4, idFamily);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Reminder r = new Reminder();
				
				r.setId(rs.getInt("id"));
				r.setIdFamily(rs.getInt("idFamily"));
				r.setIdTask(rs.getInt("idTask"));
				r.setIdOccurrence(rs.getInt("idOccurrence"));
				r.setTitle(rs.getString("title"));
				r.setDescription(rs.getString("description"));
				reminders.add(r);
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

		return reminders.get(0);
	}

	@Override
	public int getMaxId(int idFamily, int idTask, int idOccurrence) {
		int maxId = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select MAX (id) from reminder where \"idFamily\" = ? and \"idTask\" = ? and \"idOccurrence\" = ?");
		
			pstmt.setInt(1, idFamily);
			pstmt.setInt(2, idTask);
			pstmt.setInt(3, idOccurrence);
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
	public void insert(Reminder reminder) {
		if (reminder == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("insert into reminder (title, description, \"idFamily\", \"idTask\", \"idOccurrence\") values ( ?, ?, ?, ?, ?)");

			pstmt.setString(1, reminder.getTitle());
			pstmt.setString(2, reminder.getDescription());
			pstmt.setInt(3, reminder.getIdFamily());
			pstmt.setInt(4, reminder.getIdTask());
			pstmt.setInt(5, reminder.getIdOccurrence());

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
	public void remove(Reminder reminder) {
		if (reminder == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("delete from reminder where id = ? and \"idTask\" = ? and \"idOccurrence\" = ? and \"idFamily\" = ?");
			pstmt.setInt(1, reminder.getId());
			pstmt.setInt(2, reminder.getIdTask());
			pstmt.setInt(3, reminder.getIdOccurrence());
			pstmt.setInt(4, reminder.getIdFamily());
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
	public void edit(Reminder reminder) {
		if (reminder == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("update reminder set title = ?, description = ? where id = ? and \"idTask\" = ? and \"idOccurrence\" = ? and \"idFamily\" = ?");

			pstmt.setString(1, reminder.getTitle());
			pstmt.setString(2, reminder.getDescription());
			pstmt.setInt(3, reminder.getId());
			pstmt.setInt(4, reminder.getIdTask());
			pstmt.setInt(5, reminder.getIdOccurrence());
			pstmt.setInt(6, reminder.getIdFamily());

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
