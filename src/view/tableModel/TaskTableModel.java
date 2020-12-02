package view.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Task;

public class TaskTableModel extends  AbstractTableModel{


	private List<Task> tasks;
	private static final String names[] = {"Task"};

	public TaskTableModel() {
		this.tasks = new ArrayList<Task>();
	}
	
	public TaskTableModel(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
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
	
	public Task getTask(int rowIndex) {
		return tasks.get(rowIndex);
	}
	
	public void addTask(Task task) {
		this.tasks.add(task);
		this.fireTableDataChanged();
	}

}
