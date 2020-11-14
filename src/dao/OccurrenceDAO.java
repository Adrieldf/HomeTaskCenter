package dao;

import java.util.List;

import model.Occurrence;


public interface OccurrenceDAO {
	List<Occurrence> getAll( int idTask,int idFamily);
	Occurrence getById(int id, int idTask, int idFamily);
    void insert(Occurrence occurrence);
    void remove(Occurrence occurrence);
    void edit(Occurrence occurrence);
	int getMaxId(int idFamily, int idTask);
}
