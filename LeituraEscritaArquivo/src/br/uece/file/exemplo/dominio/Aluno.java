package br.uece.file.exemplo.dominio;

import java.io.Serializable;

public class Aluno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nome;

	public Aluno(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
