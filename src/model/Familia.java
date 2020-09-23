package model;

import java.util.List;

public class Familia {
	
	private String nome;
	private List<User> integrantes;
	private List<Tarefa> tarefas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<User> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<User> integrantes) {
		this.integrantes = integrantes;
	}
	
	
	
	
	

}
