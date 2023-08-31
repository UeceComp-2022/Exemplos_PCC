package br.uece.sise.dominio;


//Presidente "é um" funcionário
public class Presidente extends Funcionario{

	@Override
	public void aplicarBeneficio() {
		this.salario = this.salario +(this.salario.doubleValue()*0.4);
	}

}
