package dao;

import java.util.List;

import model.Occurrence;


public interface OccurrenceDAO {
	List<Occurrence> getAll();
	Occurrence getById(int id);
    void insert(Occurrence ocurrence);
    void remove(Occurrence ocurrence);
    void edit(Occurrence ocurrence);
}
