package br.uece.sise;

import br.uece.sise.dominio.Funcionario;
import br.uece.sise.dominio.Presidente;
import br.uece.sise.dominio.Secretario;

public class Main {
	
	public static void main(String[] args) {
		
		Funcionario presidente = new Presidente();
		Funcionario secretario = new Secretario();
		
		presidente.setNome("Eugenio Alves");
		presidente.setSalario(10000.00);
		
		secretario.setNome("Marcos");
		secretario.setSalario(1320.00);
		
		System.out.println(presidente.getNome());
		System.out.println(presidente.getSalario());
		Presidente presidenteCast = (Presidente)presidente;
		presidenteCast.relizarDecisoes();
		
		System.out.println("-----");
		
		System.out.println(secretario.getNome());
		System.out.println(secretario.getSalario());
		
		if(secretario instanceof Secretario) {
			((Secretario) secretario).organizarAgenda();
		}
			
	}
	
}
