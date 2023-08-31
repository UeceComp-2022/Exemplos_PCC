package br.uece.sisacad.dominio;
import java.util.List;
public class Turma {
	private String codigoTurma;
	
	private List<Aluno> alunos;
	
	public void exibirAlunos() {
		for (Aluno aluno : alunos) {
			System.out.println("Aluno: " + aluno.getNome() + " - " + 
             aluno.getMatricula());
		}
	}
	public String getCodigoTurma() {
		return codigoTurma;
	}
	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
}
