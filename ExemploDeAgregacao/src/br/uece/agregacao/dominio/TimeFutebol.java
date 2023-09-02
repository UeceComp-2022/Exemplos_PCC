package br.uece.agregacao.dominio;
import java.util.*;

public class TimeFutebol {
  
  private List<Jogador> jogadores; 
  
  private String nome;
  
  public TimeFutebol(){
    this.setNome("Sem Nome");
  }

  public String getNome(){
    return this.nome;
  }
  
  public void setNome(String Nome){
    this.nome = nome;
  }
  
  public List<Jogador> getJogadores(){
  
    if(jogadores!= null && jogadores.size() <11){
        throw new RuntimeException(
          "Tem que ter no mínimo 11 ou mais jogadores"
        );
    }
      
    return this.jogadores;
  }
  
  public void setJogadores(List<Jogador> jogadores){
    this.jogadores = jogadores;
  }

}