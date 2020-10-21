package model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String password;
	private int idFamily;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdFamily() {
		return idFamily;
	}

	public void setIdFamily(int idFamily) {
		this.idFamily = idFamily;
	}

	public User() {
		super();
	}

	public User(int id, String name, String password, int idFamily) {
		super();
		this.setId(id);
		this.setName(name);
		this.setPassword(password);
		this.setIdFamily(idFamily);
	}

}
