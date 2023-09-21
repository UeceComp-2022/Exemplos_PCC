package br.uece.listadetarefas.negocio;

import java.util.List;

import br.uece.listadetarefas.persistencia.RepositorioTarefa;

public class ServicoTarefa {

	private RepositorioTarefa repositorioTarefa;

	public ServicoTarefa(RepositorioTarefa repositorioTarefa) {
		this.repositorioTarefa = repositorioTarefa;
	}

	public List<Tarefa> listarTarefas() {
		List<Tarefa> tarefas = repositorioTarefa.listarTarefas();
		if (tarefas.isEmpty()) {
			throw new AgendaNegocioException("Nenhuma tarefa encontrada.");
		}
		return tarefas;
	}

	public void criarTarefa(String titulo, String descricao) {
		Tarefa novaTarefa = new Tarefa(titulo, descricao);
		repositorioTarefa.salvarTarefa(novaTarefa);
	}

	public void atualizarTarefa(int id, String novoTitulo, String novaDescricao) {
		Tarefa tarefaAtualizada = new Tarefa(id, novoTitulo, novaDescricao);
		repositorioTarefa.atualizarTarefa(tarefaAtualizada);
	}
		
	public void removerTarefa(int id) {
		Tarefa tarefaExistente = this.buscarTarefaPorId(id);
		repositorioTarefa.excluirTarefa(tarefaExistente);
	}
	
	public Tarefa buscarTarefaPorId(int id) {
		Tarefa tarefaExistente = repositorioTarefa.buscarTarefaPorId(id);
		
		if (tarefaExistente == null) {
			throw new AgendaNegocioException("Tarefa não encontrada.");
		}
		
		return tarefaExistente;
	}

}
