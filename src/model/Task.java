package model;

import java.util.List;

public class Task {

	private String name;
	private	String description;
	private List<User> responsible;
	private boolean completed;
	
	private List<Product> products;
	private List<Occurrence> occurrences;
	
	
	public Task() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getResponsible() {
		return responsible;
	}

	public void setResponsible(List<User> responsible) {
		this.responsible = responsible;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	
}
