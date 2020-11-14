package dao;

import java.util.List;

import model.Message;

public interface MessageDAO {
	List<Message> getAll();
	Message getById(int id);
    void insert(Message message);
    void remove(Message message);
    void edit(Message message);
}
