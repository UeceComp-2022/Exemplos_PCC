package br.uece.sise.dominio;


//Presidente "é um" funcionário
public class Presidente extends Funcionario{

	public void relizarDecisoes() {
		System.out.println("...Decido. Aumento para todos!!!");
	}

	
}
