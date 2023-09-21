package br.uece.listadetarefas.apresentacao;

import java.util.List;
import java.util.Scanner;

import br.uece.listadetarefas.negocio.AgendaNegocioException;
import br.uece.listadetarefas.negocio.ServicoTarefa;
import br.uece.listadetarefas.negocio.Tarefa;

/**
 * Interface de Console de Usuário
 */
public class ConsoleUserInterface {

	private ServicoTarefa servicoTarefa;

	public ConsoleUserInterface(ServicoTarefa servicoTarefa) {
		this.servicoTarefa = servicoTarefa;
	}

	public void iniciar() {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			try {
				exibirOpcoesMenu();
				int opcao = scanner.nextInt();
				scanner.nextLine();

				switch (opcao) {
				case 1:
					listarTarefas();
					break;
				case 2:
					criarTarefa(scanner);
					break;
				case 3:
					atualizarTarefa(scanner);
					break;
				case 4:
					removerTarefa(scanner);
					break;
				case 5:
					System.out.println("Saindo da aplicação.");
					scanner.close();
					System.exit(0);
				default:
					System.err.println("Opção inválida. Tente novamente.");
				}
			} catch (AgendaNegocioException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	// CREATE
	private void criarTarefa(Scanner scanner) {
		System.out.print("Digite o título da tarefa: ");
		String titulo = scanner.nextLine();
		System.out.print("Digite a descrição da tarefa: ");
		String descricao = scanner.nextLine();
		servicoTarefa.criarTarefa(titulo, descricao);
		System.out.println("Tarefa criada com sucesso!");
	}

	// READ
	private void listarTarefas() {
		List<Tarefa> tarefas = servicoTarefa.listarTarefas();
		System.out.println("==================== Tarefa ====================");
		for (Tarefa tarefa : tarefas) {
			formatarImprimirTarefa(tarefa);
			System.out.println("------------------------------------------------");
		}
	}

	// UPDATE
	private void atualizarTarefa(Scanner scanner) {
		System.out.print("Digite o ID da tarefa que deseja atualizar: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		Tarefa tarefaExistente = servicoTarefa.buscarTarefaPorId(id);
		System.out.println("==================== Tarefa ====================");
		formatarImprimirTarefa(tarefaExistente);
		System.out.println("------------------------------------------------");

		System.out.print("Digite o novo 'título' da tarefa: ");
		String novoTitulo = scanner.nextLine();
		// scanner.nextLine();
		System.out.print("Digite a nova 'descrição' da tarefa: ");
		String novaDescricao = scanner.nextLine();

		servicoTarefa.atualizarTarefa(id, novoTitulo, novaDescricao);
		System.out.println("Tarefa atualizada com sucesso!");
	}

	// DELETE
	private void removerTarefa(Scanner scanner) {
		System.out.print("Digite o ID da tarefa que deseja remover:");
		int id = scanner.nextInt();
		scanner.nextLine();
		servicoTarefa.removerTarefa(id);
		System.out.println("Tarefa " + id + " removida com sucesso!");
	}

	private void exibirOpcoesMenu() {
		System.out.println("==== Menu ====");
		System.out.println("1. Listar Tarefas");
		System.out.println("2. Criar Tarefa");
		System.out.println("3. Atualizar Tarefa");
		System.out.println("4. Remover Tarefa");
		System.out.println("5. Sair");
		System.out.print("Escolha uma opção: ");
	}

	private void formatarImprimirTarefa(Tarefa tarefa) {
		String id = "[" + tarefa.getId() + "] ";
		String titulo = tarefa.getTitulo();
		String descricao = tarefa.getDescricao();
		System.out.println(id + titulo + " - " + descricao);
	}
}
