package model;

public class Message {
	
	private int id;
	private int idTask;
	private int idOccurrence;
	private int idReminder;
	private int idFamily;
	private String sender;
	private String receiver;
	private String message;
	
	
	public Message() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTask() {
		return idTask;
	}

	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}

	public int getIdOccurrence() {
		return idOccurrence;
	}

	public void setIdOccurrence(int idOccurrence) {
		this.idOccurrence = idOccurrence;
	}

	public int getIdReminder() {
		return idReminder;
	}

	public void setIdReminder(int idReminder) {
		this.idReminder = idReminder;
	}

	public int getIdFamily() {
		return idFamily;
	}

	public void setIdFamily(int idFamily) {
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
