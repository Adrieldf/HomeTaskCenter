package view.tableModel;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Task;
import model.User;

public class TaskListTableModel extends AbstractTableModel {

	private List<Task> tasks;
	
	//nao lembro pra que serve
	private static final String names[] = {"Category"};

	public TaskListTableModel() {
		this.tasks = new ArrayList<Task>();
	}
	
	public TaskListTableModel(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public List<Task> getMembers() {
		return tasks;
	}

	public void setMembers(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public String getColumnName(int number) {
		return names[number];
	}
	
	public void removeTask(int position) {
		this.tasks.remove(position);
		return;
	}

	@Override
	public int getRowCount() {
		if (tasks != null) {
			return tasks.size();
		} else {
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Task task = tasks.get(rowIndex);
		return task.getName();
	}
	
	public Task getMember(int rowIndex) {
		return tasks.get(rowIndex);
	}
	
	public void addMember(Task task) {
		this.tasks.add(task);
		this.fireTableDataChanged();
	}

}