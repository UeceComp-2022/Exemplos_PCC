package br.uece.listadetarefas;

import br.uece.listadetarefas.apresentacao.InterfaceUsuario;
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
			InterfaceUsuario interfaceUsuario = new InterfaceUsuario(servicoTarefa);

			interfaceUsuario.iniciar();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
