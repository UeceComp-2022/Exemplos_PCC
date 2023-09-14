package com.listadetarefas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.listadetarefas.infraestrutura.persistencia.ConexaoJdbcUtil;

public class Main {
	
    public static void main(String[] args) {

		try {

			new Main().iniciar();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public void iniciar() {
    	
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirOpcoesMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

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

    private void listarTarefas() {
        String sql = "SELECT * FROM tarefa";
		try (PreparedStatement stmt = ConexaoJdbcUtil.obterConexao().prepareStatement(sql)) {
            int cont = 0;
			ResultSet resultado = stmt.executeQuery();
            
            System.out.println("==== Tarefas ====");
            while (resultado.next()) {
            	cont++;
                System.out.println("ID: " + resultado.getInt("id"));
                System.out.println("Título: " + resultado.getString("titulo"));
                System.out.println("Descrição: " + resultado.getString("descricao"));
                System.out.println("-----------------");
            }
            
            if (cont==0) {
                System.out.println("Nenhuma tarefa encontrada.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void criarTarefa(Scanner scanner) {
        System.out.print("Digite o título da tarefa: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();

        String sql = "INSERT INTO tarefa (titulo, descricao) VALUES (?, ?)";
        try (PreparedStatement stmt = ConexaoJdbcUtil.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, titulo);
            stmt.setString(2, descricao);
            stmt.executeUpdate();
            System.out.println("Tarefa criada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    private void atualizarTarefa(Scanner scanner) {
        System.out.print("Digite o ID da tarefa que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        boolean tarefaInexistente = !isTarefaExistente(id);

        if (tarefaInexistente) {
            System.out.println("Tarefa não encontrada.");
            return;//sai do método
        }

        System.out.print("Digite o novo título da tarefa: ");
        String novoTitulo = scanner.nextLine();
        System.out.print("Digite a nova descrição da tarefa: ");
        String novaDescricao = scanner.nextLine();

        String sql = "UPDATE tarefa SET titulo = ?, descricao = ? WHERE id = ?";
        try (PreparedStatement stmt = ConexaoJdbcUtil.obterConexao().prepareStatement(sql)) {
            stmt.setString(1, novoTitulo);
            stmt.setString(2, novaDescricao);
            stmt.setInt(3, id);
            System.out.println("Tarefa atualizada com sucesso!");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        
    }

    private void removerTarefa(Scanner scanner) {
        System.out.print("Digite o ID da tarefa que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        boolean tarefaInexistente = !isTarefaExistente(id);

        if (tarefaInexistente) {
            System.out.println("Tarefa não encontrada.");
            return;
        }
        
        String sql = "DELETE FROM tarefa WHERE id = ?";
        try (PreparedStatement stmt = ConexaoJdbcUtil.obterConexao().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Tarefa removida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
    }
    
    public boolean isTarefaExistente(int id) {
        String sql = "SELECT true FROM tarefa WHERE id = ?";
        try (PreparedStatement stmt = ConexaoJdbcUtil.obterConexao().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
