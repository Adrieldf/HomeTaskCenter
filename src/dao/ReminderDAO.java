package dao;

import java.util.List;

import model.Reminder;

public interface ReminderDAO {
	List<Reminder> getAll(int idFamily);
	Reminder getById(int id, int idFamily);
    void insert(Reminder reminder);
    void remove(Reminder reminder);
    void edit(Reminder reminder);
}
