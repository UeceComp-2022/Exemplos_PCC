package br.uece.sise;

import br.uece.sise.dominio.Funcionario;
import br.uece.sise.dominio.Presidente;
import br.uece.sise.dominio.Secretario;

public class Main {
	
	public static void main(String[] args) {
		
		//Passo 1 - Criar instancias
		Funcionario presidente = new Presidente();
		Funcionario secretario = new Secretario();
		
		//Passo 2 - Adiscionar dados, ou seja, 
		//   alterar o estado dos objetos 
		presidente.setNome("Eugenio Alves");
		presidente.setSalario(1000.00);		
		secretario.setNome("Marcos");
		secretario.setSalario(1000.00);
		
		//Passo 3 - Aplicar benefícios 
		presidente.aplicarBeneficio();
		secretario.aplicarBeneficio();
		
		//Passo 4 - Imprimir dados alterados
		System.out.println(presidente.getNome());
		System.out.println(presidente.getSalario());		
		System.out.println("-----");		
		System.out.println(secretario.getNome());
		System.out.println(secretario.getSalario());
		
			
	}
	
}
