//package br.uece.listadetarefas.aplicacao;
//
//import java.util.List;
//
//import br.uece.listadetarefas.dominio.modelo.Tarefa;
//import br.uece.listadetarefas.dominio.repositorio.RepositorioTarefaPorta;
//
//public class ServicoTarefaAdapter implements ManterTarefaCasoDeUso {
//    
//	private RepositorioTarefaPorta repositorioTarefa;
//
//    public ServicoTarefaAdapter(RepositorioTarefaPorta repositorioTarefa) {
//        this.repositorioTarefa = repositorioTarefa;
//    }
//
//    @Override
//    public void criarTarefa(Tarefa tarefa) {
//        // Lógica de criação da tarefa, se necessário.
//        repositorioTarefa.salvarTarefa(tarefa);
//    }
//
//    @Override
//    public Tarefa buscarTarefaPorId(int id) {
//        return repositorioTarefa.buscarTarefaPorId(id);
//    }
//
//    @Override
//    public List<Tarefa> listarTarefas() {
//        return repositorioTarefa.listarTarefas();
//    }
//
//    @Override
//    public void atualizarTarefa(Tarefa tarefa) {
//        // Lógica de atualização da tarefa, se necessário.
//        repositorioTarefa.atualizarTarefa(tarefa);
//    }
//
//    @Override
//    public void excluirTarefa(int id) {
//        // Lógica de exclusão da tarefa, se necessário.
//        repositorioTarefa.excluirTarefa(id);
//    }
//
//
//}


