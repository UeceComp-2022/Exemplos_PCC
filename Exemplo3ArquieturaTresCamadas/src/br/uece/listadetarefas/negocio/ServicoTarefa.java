package br.uece.listadetarefas.negocio;

import java.util.List;
import java.util.Scanner;

import br.uece.listadetarefas.persistencia.RepositorioTarefa;

public class ServicoTarefa {

	private RepositorioTarefa repositorioTarefa;

	public ServicoTarefa(RepositorioTarefa repositorioTarefa) {
		this.repositorioTarefa = repositorioTarefa;
	}

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

	public void criarTarefa(Scanner scanner) {
		System.out.print("Digite o título da tarefa: ");
		String titulo = scanner.nextLine();
		System.out.print("Digite a descrição da tarefa: ");
		String descricao = scanner.nextLine();

		Tarefa novaTarefa = new Tarefa(0, titulo, descricao);
		repositorioTarefa.salvarTarefa(novaTarefa);
		System.out.println("Tarefa criada com sucesso!");
	}

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
