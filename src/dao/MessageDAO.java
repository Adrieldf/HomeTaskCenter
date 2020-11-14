package dao;

import java.util.List;

import model.Message;

public interface MessageDAO {
	List<Message> getAll(int idFamily);
	Message getById(int id, int idFamily);
    void insert(Message message);
    void remove(Message message);
    void edit(Message message);
}
