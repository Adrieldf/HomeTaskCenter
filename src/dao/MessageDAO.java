package dao;

import java.util.List;

import model.Message;

public interface MessageDAO {
	List<Message> getAll(int idTask, int idOccurrence, int idReminder, int idFamily);
	Message getById(int id, int idTask, int idOccurrence, int idReminder, int idFamily);
    void insert(Message message);
    void remove(Message message);
    void edit(Message message);
    int getMaxId();
}
