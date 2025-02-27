package dao;

import java.util.List;

import model.Reminder;

public interface ReminderDAO {
	List<Reminder> getAll(int idTask, int idOccurrence, int idFamily);
	Reminder getById(int id, int idTask, int idOccurrence, int idFamily);
    void insert(Reminder reminder);
    void remove(Reminder reminder);
    void edit(Reminder reminder);
	int getMaxId(int idFamily, int idTask, int idOccurrence);
}
