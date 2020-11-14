package dao;

import java.util.List;

import model.Occurrence;


public interface OccurrenceDAO {
	List<Occurrence> getAll(int idFamily);
	Occurrence getById(int id, int idFamily);
    void insert(Occurrence ocurrence);
    void remove(Occurrence ocurrence);
    void edit(Occurrence ocurrence);
}
