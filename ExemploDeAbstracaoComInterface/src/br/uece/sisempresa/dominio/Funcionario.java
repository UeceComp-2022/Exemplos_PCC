package br.uece.sisempresa.dominio;

public class Funcionario implements Balanco, Pessoa {
	
	private String nome;
	private float salario;
	
	public Funcionario(String nome, float salario) {
		super();
		this.nome = nome;
		this.salario = salario;
	}

	@Override
	public float getBalanco() {
		return -salario;
	}

	public String getNome() {
		return nome;
	}

	public float getSalario() {
		return salario;
	}

	
	
	
}
