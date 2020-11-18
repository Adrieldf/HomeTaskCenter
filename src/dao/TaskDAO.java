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
    
    //https://pt.stackoverflow.com/questions/65736/como-retornar-o-id-de-um-registro-logo-ap%C3%B3s-ele-ser-inserido
}
