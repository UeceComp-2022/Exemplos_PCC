package br.uece.sisacad;
import br.uece.sisacad.dominio.Aluno;
import br.uece.sisacad.dominio.AlunoUece;
public class Main2 {
	public static void main(String[] args) {
		//Exemplo utilizando CAST
		Aluno objeto = new AlunoUece(); 
		AlunoUece alunoUece2 = (AlunoUece) objeto;
		System.out.println(alunoUece2.getNome());
	}
}
