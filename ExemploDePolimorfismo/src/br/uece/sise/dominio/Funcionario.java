package br.uece.sise.dominio;

public class Funcionario {

	protected String nome;
	protected Double salario;
	
	/**
	 * RF001 - O sistema deve permitir acrécimo de 20% de 
	 * benefício para todos os funcionários. O presendente,
	 * excepcionalmente, tem direito ao dobro em benefícios. 
	 */
	public void aplicarBeneficio() {
		this.salario = this.salario +(this.salario.doubleValue()*0.2);
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
}
