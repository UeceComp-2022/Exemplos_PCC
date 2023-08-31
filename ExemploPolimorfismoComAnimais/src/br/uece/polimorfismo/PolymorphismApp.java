package br.uece.polimorfismo;

import br.uece.polimorfismo.dominio.Animal;
import br.uece.polimorfismo.dominio.Vaca;
import br.uece.polimorfismo.dominio.Passaro;

public class PolymorphismApp {
	
	public static void main(String[] args) {
		
		//POLIMORFISMO:
		//Objetos de um mesmo tipom, ou seja, com a mesma superclasse, 
		//classe abstrada ou interface). possue(m) a mesma ação, que  
		//executam comportamentos diferentes.
				
		Animal animal;
		
		animal = new Vaca();
		animal.emitirSom(); 
		
		animal = new Passaro(); 		
		animal.emitirSom(); 
	}
}
