package model;

public class Message {
	
	private Integer id;
	private Integer idTask;
	private Integer idOccurrence;
	private Integer idReminder;
	private Integer idFamily;
	private String sender;
	private String receiver;
	private String message;
	
	
	public Message() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTask() {
		return idTask;
	}

	public void setIdTask(Integer idTask) {
		this.idTask = idTask;
	}

	public Integer getIdOccurrence() {
		return idOccurrence;
	}

	public void setIdOccurrence(Integer idOccurrence) {
		this.idOccurrence = idOccurrence;
	}

	public Integer getIdReminder() {
		return idReminder;
	}

	public void setIdReminder(Integer idReminder) {
		this.idReminder = idReminder;
	}

	public Integer getIdFamily() {
		return idFamily;
	}

	public void setIdFamily(Integer idFamily) {
		this.idFamily = idFamily;
	}

	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
