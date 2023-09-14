package br.uece.listadetarefas.dominio.repositorio.portas.saida;

import java.util.List;

import br.uece.listadetarefas.dominio.modelo.Tarefa;
/**
 * Interface java como porta de saida hexagonal
 */
public interface RepositorioTarefa {
    void salvarTarefa(Tarefa tarefa);
    Tarefa buscarTarefaPorId(int id);
    List<Tarefa> listarTarefas();
    void atualizarTarefa(Tarefa tarefa);
    void excluirTarefa(int id);
}
