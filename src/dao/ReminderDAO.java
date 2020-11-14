package dao;

import java.util.List;

import model.Reminder;

public interface ReminderDAO {
	List<Reminder> getAll();
	Reminder getById(int id);
    void insert(Reminder reminder);
    void remove(Reminder reminder);
    void edit(Reminder reminder);
}
