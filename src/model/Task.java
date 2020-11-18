package model;

import java.util.List;

public class Task {

	private Integer id;
	private String name;
	private	String description;
	private Integer idFamily;
	private Integer idUser;
	private boolean completed;
	
	private List<User> responsible;
	private List<Product> products;
	private List<Occurrence> occurrences;
	//nao tem data e hora, mas esta sendo inserido na janela
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdFamily() {
		return idFamily;
	}

	public void setIdFamily(int idFamily) {
		this.idFamily = idFamily;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	
}
