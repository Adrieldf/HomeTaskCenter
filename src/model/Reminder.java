package model;

public class Reminder {
	
	private Integer id;
	private String title;
	private String description;
	private Integer idOccurrence;
	private Integer idTask;
	private Integer idFamily;

	
	public Reminder() {
		
	}
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdOccurrence() {
		return idOccurrence;
	}

	public void setIdOccurrence(Integer idOccurrence) {
		this.idOccurrence = idOccurrence;
	}

	public Integer getIdTask() {
		return idTask;
	}

	public void setIdTask(Integer idTask) {
		this.idTask = idTask;
	}

	public Integer getIdFamily() {
		return idFamily;
	}

	public void setIdFamily(Integer idFamily) {
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
