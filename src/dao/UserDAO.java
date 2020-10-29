package dao;

import java.util.List;

import model.User;

public interface UserDAO {

	List<User> getAll();

	User getById(int id, int idFamily);

	void insert(User user);

	void remove(User user);

	void edit(User user);

	boolean validateUser(User user);
}
