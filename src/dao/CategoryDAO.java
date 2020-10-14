package dao;

import java.util.List;

import model.Category;

public interface CategoryDAO {
	
	   	List<Category> getAll( );
	    List<Category> getById(int id);
	    void insert(Category category);
	    void remove(Category category);
	    void edit(Category category);
}
