package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TaskDAO;
import model.Task;

public class PostgresqlTaskDB implements TaskDAO {

	private Connection conn;

	public PostgresqlTaskDB(Connection conn) {
		this.conn = conn;
	}

	
	@Override
	public List<Task> getAll(int idFamily) {
		List<Task> tasks = new ArrayList<Task>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select * from task where \"idFamily\" = ?");
			pstmt.setInt(1, idFamily);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Task t = new Task();
				
				t.setId(rs.getInt("id"));
				t.setIdFamily(rs.getInt("idFamily"));
				t.setIdUser(rs.getInt("idUser"));
				t.setName(rs.getString("name"));
				t.setDescription(rs.getString("description"));
				t.setCompleted(rs.getBoolean("completed"));
				tasks.add(t);
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

		return tasks;
	}

	@Override
	public Task getById(int id, int idFamily) {
		List<Task> tasks = new ArrayList<Task>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select * from task where id = ? and \"idFamily\" = ?");
			pstmt.setInt(1, id);
			pstmt.setInt(2, idFamily);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Task t = new Task();
				
				t.setId(rs.getInt("id"));
				t.setIdFamily(rs.getInt("idFamily"));
				t.setIdUser(rs.getInt("idUser"));
				t.setName(rs.getString("name"));
				t.setDescription(rs.getString("description"));
				t.setCompleted(rs.getBoolean("completed"));
				tasks.add(t);
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

		return tasks.get(0);
	}

	@Override
	public int getMaxId(int idFamily) {
		int maxId = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement("select MAX (id) from task where \"idFamily\" = ?");
		
			pstmt.setInt(1, idFamily);
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
	public void insert(Task task) {
		if (task == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("insert into task (name, description, completed, \"idFamily\", \"idUser\") values ( ?, ?, ?, ?, ? )");

			pstmt.setString(1, task.getName());
			pstmt.setString(2, task.getDescription());
			pstmt.setBoolean(3, task.isCompleted());
			pstmt.setInt(4, task.getIdFamily());
			pstmt.setInt(5, task.getIdUser());

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
	public void remove(Task task) {
		if (task == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("delete from task where id = ? and \"idFamily\" = ?");
			pstmt.setInt(1, task.getId());
			pstmt.setInt(2, task.getIdFamily());
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
	public void edit(Task task) {
		if (task == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("update task set name = ?, description = ?, completed = ? where id = ? and \"idFamily\" = ?");

			pstmt.setString(1, task.getName());
			pstmt.setString(2, task.getDescription());
			pstmt.setBoolean(3, task.isCompleted());
			pstmt.setInt(4, task.getId());
			pstmt.setInt(5, task.getIdFamily());

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
