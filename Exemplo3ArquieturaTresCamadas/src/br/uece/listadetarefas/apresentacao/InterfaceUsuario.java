package br.uece.listadetarefas.apresentacao;

import java.util.List;
import java.util.Scanner;

import br.uece.listadetarefas.negocio.Tarefa;
import br.uece.listadetarefas.negocio.ServicoTarefa;
import br.uece.listadetarefas.persistencia.RepositorioTarefa;

public class InterfaceUsuario {
	
    private ServicoTarefa servicoTarefa;

    public InterfaceUsuario(ServicoTarefa servicoTarefa) {
        this.servicoTarefa = servicoTarefa;
    }

    public void iniciar() {
    	
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirOpcoesMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (opcao) {
                case 1:
                	servicoTarefa.listarTarefas();
                    break;
                case 2:
                	servicoTarefa.criarTarefa(scanner);
                    break;
                case 3:
                	servicoTarefa.atualizarTarefa(scanner);
                    break;
                case 4:
                	servicoTarefa.removerTarefa(scanner);
                    break;
                case 5:
                    System.out.println("Saindo da aplicação.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
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

}
