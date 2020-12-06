package dao;

import java.util.List;

import model.Product;

public interface ProductDAO {

	List<Product> getAll(int idFamily);

	List<Product> getById(int id, int idFamily);

	void insert(Product product);

	void remove(Product product);

	void edit(Product product);
	int getMaxId();
}
