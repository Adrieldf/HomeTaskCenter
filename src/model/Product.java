package model;


public class Product {
	
	private int id;
	private String name;
	private int idCategory;
	

	public Product(int id, String name, int idCategory) {
		this.setId(id);
		this.setName(name);
		this.setIdCategory(idCategory);
	}
	public Product() {
		
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdCategory() {
		return idCategory;
	}


	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



}
