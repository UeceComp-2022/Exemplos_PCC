package br.uece.composicao.dominio;
public class Jogador {
  
  private TimeFutebol time;
  private String nome;
  
  public Jogador(String nome){
    this.nome = nome;
  }

  
  public String getNome(){
    return this.nome;
  }
  
  public TimeFutebol getTime(){
    return this.time;
  }
  
  public void getTime(TimeFutebol time){
    this.time = time;
  }

}