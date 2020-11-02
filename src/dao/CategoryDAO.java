package dao;

import java.util.List;

import model.Category;

public interface CategoryDAO {
	
	   	List<Category> getAll(int idFamily);
	    List<Category> getById(int id, int idFamily);
	    void insert(Category category);
	    void remove(Category category);
	    void edit(Category category);
}
