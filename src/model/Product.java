package model;


public class Product {
	
	private int idFamily;
	private int id;
	private String name;
	//sepa trocar de int para list
	private int idCategory;
	

	public Product(int id, String name, int idCategory, int idFamily) {
		this.setId(id);
		this.setName(name);
		this.setIdCategory(idCategory);
		this.setIdFamily(idFamily);
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
	public int getIdFamily() {
		return idFamily;
	}
	public void setIdFamily(int idFamily) {
		this.idFamily = idFamily;
	}



}
