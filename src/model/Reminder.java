package model;

public class Reminder {
	
	private int id;
	private String title;
	private String description;
	private int idOccurrence;
	private int idTask;
	private int idFamily;

	
	public Reminder() {
		
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdOccurrence() {
		return idOccurrence;
	}

	public void setIdOccurrence(int idOccurrence) {
		this.idOccurrence = idOccurrence;
	}

	public int getIdTask() {
		return idTask;
	}

	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}

	public int getIdFamily() {
		return idFamily;
	}

	public void setIdFamily(int idFamily) {
		this.idFamily = idFamily;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
