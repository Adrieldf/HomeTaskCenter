package dao;

import java.util.List;

import model.Family;

public interface FamilyDAO {
	List<Family> getAll();
	Family getById(int id);
    void insert(Family family);
    void remove(Family family);
    void edit(Family family);
    int getMaxId();
}
