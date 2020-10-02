package model;

import java.util.List;

public class Family {
	
	private String name;
	private List<User> members;
	private List<Task> tasks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}
	
	
	
	
	

}
