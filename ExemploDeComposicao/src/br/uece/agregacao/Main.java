package br.uece.agregacao;
import java.util.ArrayList;
import java.util.List;

import br.uece.agregacao.dominio.Jogador;
import br.uece.agregacao.dominio.TimeFutebol;

public class Main {
    public static void main(String[] args) {
      try{
        
              
              List<Jogador> lista = new ArrayList<>();
        
              lista.add(new Jogador("Joao"));
              lista.add(new Jogador("Ronaldo"));
              lista.add(new Jogador("Ronaldo"));
              lista.add(new Jogador("Joao"));
              lista.add(new Jogador("Ronaldo"));
              lista.add(new Jogador("Ronaldo"));
              lista.add(new Jogador("Joao"));
              lista.add(new Jogador("Joao"));
              lista.add(new Jogador("Ronaldo"));
              lista.add(new Jogador("Ronaldo"));
              lista.add(new Jogador("Joao"));      
              
              TimeFutebol time = new TimeFutebol(lista);
              
              System.out.println(
                "Quantidade: "+ time.getJogadores().size()
              );
              
      }catch(Exception e){
          System.out.println("Oops...: " +e.getMessage());
      }
  }
}