package br.uece.sisacad;
import br.uece.sisacad.dominio.Aluno;
import br.uece.sisacad.dominio.AlunoUece;
public class Main1 {
	public static void main(String[] args) {
		//Exemplo sem uso de CAST
		AlunoUece alunoUece1  = new AlunoUece();  
		Aluno other = alunoUece1;
		other.setNome("Maria");
		System.out.println(other.getNome());
		
		//Exemplo utilizando CAST
		Aluno objeto = new AlunoUece(); 
		AlunoUece alunoUece2 = (AlunoUece) objeto;
		alunoUece2.setNome("João");
		System.out.println(alunoUece2.getNome());
	}
}