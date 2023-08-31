package br.uece.sisempresa.dominio;

public class Secretaria implements Balanco, Pessoa {
	
	private String nome;
	private float salario;
	
	public Secretaria(String nome, float salario) {
		super();
		this.nome = nome;
		this.salario = salario;
	}

	@Override
	public float getBalanco() {
		return 2*salario;
	}
	
	@Override
	public String getNome() {
		return nome;
	}

	public float getSalario() {
		return salario;
	}

	
	
	
}
