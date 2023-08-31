package br.uece.polimorfismo;

import br.uece.polimorfismo.dominio.A;
import br.uece.polimorfismo.dominio.B;
import br.uece.polimorfismo.dominio.C;

public class PolymorphismApp {
	
	public static void main(String[] args) {
		
		A obj;
		
		obj = new B();// classe de criação B
		obj.F(); // B.F
		
		obj = new C(); // classe de criação C
		
		obj.F(); // C.F
	}
}
