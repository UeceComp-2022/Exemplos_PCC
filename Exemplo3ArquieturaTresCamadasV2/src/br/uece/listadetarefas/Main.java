package br.uece.listadetarefas;

import br.uece.listadetarefas.apresentacao.ConsoleUserInterface;
import br.uece.listadetarefas.negocio.ServicoTarefa;
import br.uece.listadetarefas.persistencia.RepositorioTarefa;
import br.uece.listadetarefas.persistencia.RepositorioTarefaJdbc;

public class Main {
	
	public static void main(String[] args) {

		try {
			
			// Acesso  a camada de Persitência
			RepositorioTarefa repositorioTarefa = new RepositorioTarefaJdbc();

			// Acesso a camada de serviços/Negócio
			ServicoTarefa servicoTarefa = new ServicoTarefa(repositorioTarefa);

			// Acesso a interface de usuário (console, linha de comando, etc.)
			ConsoleUserInterface interfaceUsuario = new ConsoleUserInterface(servicoTarefa);

			interfaceUsuario.iniciar();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
	}
}
