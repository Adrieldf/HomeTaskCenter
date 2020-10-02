package model;

public class Occurrence {
	//talvez mudar o tipo
	private int date;
	private int hour;
	
	private Reminder reminder;
	
	public Occurrence() {
		
	}
	
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	
	
	

}
