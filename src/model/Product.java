package model;


public class Product {
	
	private Integer idFamily;
	private Integer id;
	private String name;
	//sepa trocar de int para list
	private Integer idCategory;
	//checkbox aqui

	public Product(Integer id, String name, Integer idCategory, Integer idFamily) {
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


	public void setIdCategory(Integer idCategory) {
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
	public void setIdFamily(Integer idFamily) {
		this.idFamily = idFamily;
	}



}
