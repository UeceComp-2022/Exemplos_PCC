package br.uece.sisacad.dominio;

import java.util.Random;

public class Aluno {
	
	private String nome;
	private String matricula;
	private Turma turma;
	
	public void realizarMatricula() {
		this.matricula = "00" + new Random().nextInt(10) ;
		System.out.println("Aluno: "+this.nome);
		System.out.println("Matricula realizada: "+this.matricula);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {		
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
	
	

}
