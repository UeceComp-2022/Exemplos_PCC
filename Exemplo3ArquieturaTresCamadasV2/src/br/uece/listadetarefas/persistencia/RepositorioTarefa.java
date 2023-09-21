package br.uece.listadetarefas.persistencia;

import java.util.List;

import br.uece.listadetarefas.negocio.Tarefa;

public interface RepositorioTarefa{//Porta de Saída
    void salvarTarefa(Tarefa tarefa);
    Tarefa buscarTarefaPorId(int id);
    List<Tarefa> listarTarefas();
    void atualizarTarefa(Tarefa tarefa);
    void excluirTarefa(Tarefa tarefa);
}
