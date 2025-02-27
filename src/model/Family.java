package model;

import java.util.ArrayList;
import java.util.List;

public class Family {

	private Integer id;
	private String name;
	
	private List<User> members;

	public Family() {
		members = new ArrayList<User>();
	}

	public Family(String name) {
		this();
		this.setName(name);
	}
	
	public Family(int id, String name) {
		this();
		this.setId(id);
		this.setName(name);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		return;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		return;
	}

	public List<User> getMermber() {
		return members;
	}

	public void setMermber(List<User> members) {
		this.members = members;
		return;
	}
	
	public void addMember(User member) {
		this.members.add(member);
		return;
	}

}
