package dao;

import java.util.List;

import model.Product;

public interface ProductDAO {

	List<Product> getAll();
    List<Product> getById(int id);
    void insert(Product product);
    void remove(Product product);
    void edit(Product product);
}
