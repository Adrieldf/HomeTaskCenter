package model;

import java.util.List;

public class Product {
	
	private String name;
	
	private List<Category> categories;
	
	public Product() {
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}
