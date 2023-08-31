package br.uece.sisempresa;

import br.uece.sisempresa.dominio.Balanco;
import br.uece.sisempresa.dominio.Funcionario;
import br.uece.sisempresa.dominio.Secretaria;

public class Main {

	public static void main(String[] args) {
		
		Balanco func1 = new Funcionario("Maria", 1000);
		Balanco func2 = new Secretaria("Claudia", 1000);
		
		//Funcionario funcionario = (Funcionario)func1;
		
		System.out.println(func1.getBalanco());
		System.out.println(func2.getBalanco());

	}

	
//	ArrayList<Balanco> lista = new ArrayList<>();
//	
//	lista.add(func1);
//	lista.add(func2);
}
