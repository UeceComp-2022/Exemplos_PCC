package br.uece.listadetarefas;

import br.uece.listadetarefas.adaptadores.entrada.InterfaceUsuario;
import br.uece.listadetarefas.adaptadores.saida.RepositorioTarefaAdapter;
import br.uece.listadetarefas.aplicacao.portas.entrada.CasoDeUsoManterTarefa;
import br.uece.listadetarefas.aplicacao.service.ServicoManterTarefa;

public class Main {
	
	public static void main(String[] args) {

		try {

			// Acesso  a camada de Persitência 
			RepositorioTarefaAdapter repositorioTarefa = new RepositorioTarefaAdapter();

			// Acesso a camada de serviços/Negócio
			CasoDeUsoManterTarefa servicoTarefa = new ServicoManterTarefa(repositorioTarefa);
			
			// Acesso a interface de usuário (console, linha de comando, etc.
			InterfaceUsuario interfaceUsuario = new InterfaceUsuario(servicoTarefa);

			interfaceUsuario.iniciar();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
