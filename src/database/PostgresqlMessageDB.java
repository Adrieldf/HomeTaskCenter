package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MessageDAO;
import model.Message;
import model.Reminder;

public class PostgresqlMessageDB implements MessageDAO {

	private Connection conn;

	public PostgresqlMessageDB(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Message> getAll(int idTask, int idOccurrence, int idReminder, int idFamily) {
		List<Message> messages = new ArrayList<Message>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select * from message where \"idTask\" = ? and \"idOccurrence\" = ? and \"idReminder\" = ? and \"idFamily\" = ?");
	
			pstmt.setInt(1, idTask);
			pstmt.setInt(2, idOccurrence);	
			pstmt.setInt(3, idReminder);
			pstmt.setInt(4, idFamily);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Message m = new Message();
				
				m.setId(rs.getInt("id"));
				m.setIdFamily(rs.getInt("idFamily"));
				m.setIdTask(rs.getInt("idTask"));
				m.setIdOccurrence(rs.getInt("idOccurrence"));
				m.setIdReminder(rs.getInt("idReminder"));
				m.setSender(rs.getString("sender"));
				m.setReceiver(rs.getString("receiver"));
				m.setMessage(rs.getString("message"));
				messages.add(m);
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

		return messages;
	}

	@Override
	public Message getById(int id, int idTask, int idOccurrence, int idReminder, int idFamily) {
		List<Message> messages = new ArrayList<Message>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select * from message where id = ? and \"idTask\" = ? and \"idOccurrence\" = ? and \"idReminder\" = ? and \"idFamily\" = ?");
			pstmt.setInt(1, id);
			pstmt.setInt(2, idTask);
			pstmt.setInt(3, idOccurrence);	
			pstmt.setInt(4, idReminder);
			pstmt.setInt(5, idFamily);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Message m = new Message();
				
				m.setId(rs.getInt("id"));
				m.setIdFamily(rs.getInt("idFamily"));
				m.setIdTask(rs.getInt("idTask"));
				m.setIdOccurrence(rs.getInt("idOccurrence"));
				m.setIdReminder(rs.getInt("idReminder"));
				m.setSender(rs.getString("sender"));
				m.setReceiver(rs.getString("receiver"));
				m.setMessage(rs.getString("message"));
				messages.add(m);
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

		return messages.get(0);
	}

	@Override
	public void insert(Message message) {
		if (message == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("insert into message (sender, receiver, message, \"idFamily\", \"idTask\", \"idOccurrence\", \"idReminder\") values ( ?, ?, ?, ?, ?, ?, ?)");

			pstmt.setString(1, message.getSender());
			pstmt.setString(2, message.getReceiver());
			pstmt.setString(3, message.getMessage());
			pstmt.setInt(4, message.getIdFamily());
			pstmt.setInt(5, message.getIdTask());
			pstmt.setInt(6, message.getIdOccurrence());
			pstmt.setInt(7, message.getIdReminder());

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
	public void remove(Message message) {
		if (message == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("delete from message where id = ? and \"idTask\" = ? and \"idOccurrence\" = ? and \"idReminder\" = ? and \"idFamily\" = ?");
			pstmt.setInt(1, message.getId());
			pstmt.setInt(2, message.getIdTask());
			pstmt.setInt(3, message.getIdOccurrence());
			pstmt.setInt(4, message.getIdReminder());
			pstmt.setInt(5, message.getIdFamily());
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
	public void edit(Message message) {
		if (message == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("update message set sender = ?, receiver = ?, message = ? where id = ? and \"idTask\" = ? and \"idOccurrence\" = ? and \"idReminder\" = ? and \"idFamily\" = ?");

			pstmt.setString(1, message.getSender());
			pstmt.setString(2, message.getReceiver());
			pstmt.setString(3, message.getMessage());
			pstmt.setInt(4, message.getId());
			pstmt.setInt(5, message.getIdTask());
			pstmt.setInt(6, message.getIdOccurrence());
			pstmt.setInt(7, message.getIdReminder());
			pstmt.setInt(8, message.getIdFamily());

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
	public int getMaxId() {
		int maxId = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select MAX (id) from message");
		
			
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
	
}
