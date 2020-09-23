package model;

import java.util.List;

public class Tarefa {

	private String nome;
	private	String descricao;
	private List<User> responsaveis;
	private boolean concluida;
	
	private List<Produto> produtos;
	private List<Ocorrencia> ocorrencias;
	
	
	public Tarefa() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<User> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<User> responsaveis) {
		this.responsaveis = responsaveis;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}
	
	
}
