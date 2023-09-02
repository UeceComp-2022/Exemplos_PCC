package br.uece.agregacao.dominio;

import java.util.*;

public class TimeFutebol {

	private List<Jogador> jogadores;

	private String nome = "Sem Nome";

	public TimeFutebol(List<Jogador> jogadores) {
		
		if( jogadores == null )
			throw new RuntimeException("A lista de jogadores é obrigatória para criar o time.");
		
		if( jogadores.size() == 0)
			throw new RuntimeException("A lista de jogadores é obrigatória");
		
		this.jogadores = jogadores;
	}

//	public TimeFutebol() {
//		this.setNome("Sem Nome");
//	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Jogador> getJogadores() {

		if (jogadores != null && jogadores.size() < 11) {
			throw new RuntimeException("Tem que ter no mínimo 11 ou mais jogadores");
		}

		return this.jogadores;
	}
}