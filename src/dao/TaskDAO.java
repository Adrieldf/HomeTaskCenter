package dao;

import java.util.List;

import model.Task;

public interface TaskDAO {
	List<Task> getAll(int idFamily);
	Task getById(int id, int idFamily);
    void insert(Task task);
    void remove(Task task);
    void edit(Task task);
    int getMaxId(int idFamily);
}
