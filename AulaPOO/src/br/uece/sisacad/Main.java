package br.uece.sisacad;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import br.uece.sisacad.dominio.Aluno;
import br.uece.sisacad.dominio.Turma;
public class Main {
	public static void main(String[] args) {
		
		//criação das instâncias de objetos do tipo Aluno
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Mario");
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Maria");
		
		aluno1.realizarMatricula();
		System.out.println("-----");
		aluno2.realizarMatricula();
		
		//Criação da lista de alunos
		//e inclusão dos objetos do tipo Aluno
		List<Aluno> listaDeAlunos = new ArrayList();//Generics: <?>
		listaDeAlunos.add(aluno1);
		listaDeAlunos.add(aluno2);
		
		//Criação da Turma e inclusão dos alunos 
		Turma turma = new Turma();
		turma.setAlunos(listaDeAlunos);
		turma.setCodigoTurma("00"+new Random().nextInt(10));
		
		System.out.println("--------------------------------------");
		System.out.println("Alunos da Turma "+ turma.getCodigoTurma() +":");
		turma.exibirAlunos();
		
		
	}
	
}
