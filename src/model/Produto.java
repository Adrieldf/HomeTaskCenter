package model;

import java.util.List;

public class Produto {
	
	private String nome;
	
	private List<Categoria> categorias;
	
	public Produto() {
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

}
