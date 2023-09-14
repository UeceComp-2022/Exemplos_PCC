package br.uece.listadetarefas.aplicacao.service;

import java.util.List;
import java.util.Scanner;

import br.uece.listadetarefas.aplicacao.portas.entrada.CasoDeUsoManterTarefa;
import br.uece.listadetarefas.dominio.modelo.Tarefa;
import br.uece.listadetarefas.dominio.repositorio.portas.saida.RepositorioTarefa;

public class ServicoManterTarefa implements CasoDeUsoManterTarefa{
	
    private RepositorioTarefa repositorioTarefa;

    public ServicoManterTarefa(RepositorioTarefa repositorio) {
        this.repositorioTarefa = repositorio;
    }

    @Override
    public void listarTarefas() {
        List<Tarefa> tarefas = repositorioTarefa.listarTarefas();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            System.out.println("==== Tarefas ====");
            for (Tarefa tarefa : tarefas) {
                System.out.println("ID: " + tarefa.getId());
                System.out.println("Título: " + tarefa.getTitulo());
                System.out.println("Descrição: " + tarefa.getDescricao());
                System.out.println("-----------------");
            }
        }
    }
    @Override
    public void criarTarefa(Scanner scanner) {
        System.out.print("Digite o título da tarefa: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();

        Tarefa novaTarefa = new Tarefa(0, titulo, descricao);
        repositorioTarefa.salvarTarefa(novaTarefa);
        System.out.println("Tarefa criada com sucesso!");
    }
    
    @Override
    public void atualizarTarefa(Scanner scanner) {
        System.out.print("Digite o ID da tarefa que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        Tarefa tarefaExistente = repositorioTarefa.buscarTarefaPorId(id);

        if (tarefaExistente == null) {
            System.out.println("Tarefa não encontrada.");
            return;
        }

        System.out.print("Digite o novo título da tarefa: ");
        String novoTitulo = scanner.nextLine();
        System.out.print("Digite a nova descrição da tarefa: ");
        String novaDescricao = scanner.nextLine();

        Tarefa tarefaAtualizada = new Tarefa(id, novoTitulo, novaDescricao);
        repositorioTarefa.atualizarTarefa(tarefaAtualizada);
        System.out.println("Tarefa atualizada com sucesso!");
    }

    @Override
    public void removerTarefa(Scanner scanner) {
        System.out.print("Digite o ID da tarefa que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        Tarefa tarefaExistente = repositorioTarefa.buscarTarefaPorId(id);

        if (tarefaExistente == null) {
            System.out.println("Tarefa não encontrada.");
            return;
        }

        repositorioTarefa.excluirTarefa(id);
        System.out.println("Tarefa removida com sucesso!");
    }
}
