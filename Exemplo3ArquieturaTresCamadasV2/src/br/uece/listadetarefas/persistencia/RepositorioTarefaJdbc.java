package br.uece.listadetarefas.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.uece.listadetarefas.negocio.Tarefa;

/**
 * Implementação da Porta de Saída, no caso saída para o banco de dados
 */
public class RepositorioTarefaJdbc implements RepositorioTarefa {
	
    private Connection conexao;

    public RepositorioTarefaJdbc() {
		
        try {
        	
			this.conexao = ConexaoJdbcUtil.obterConexao();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }

    @Override
    public void salvarTarefa(Tarefa tarefa) {
        String sql = "INSERT INTO tarefa (titulo, descricao) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException e) {
        	throw new RuntimeException(e);
        }
    }

    @Override
    public Tarefa buscarTarefaPorId(int id) {
        String sql = "SELECT * FROM tarefa WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                return mapearResultadoParaTarefa(resultado);
            }
        } catch (SQLException e) {
        	throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Tarefa> listarTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM tarefa order by id asc";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                tarefas.add(mapearResultadoParaTarefa(resultado));
            }
        } catch (SQLException e) {
        	throw new RuntimeException(e);
        }
        return tarefas;
    }

    @Override
    public void atualizarTarefa(Tarefa tarefa) {
        String sql = "UPDATE tarefa SET titulo = ?, descricao = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setInt(3, tarefa.getId());
            stmt.executeUpdate();
            System.out.println("[SQL] UPDATE O com sucesso!");
        } catch (SQLException e) {
        	throw new RuntimeException(e);
        }
    }

    @Override
    public void excluirTarefa(Tarefa tarefa) {
        String sql = "DELETE FROM tarefa WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, tarefa.getId());
            stmt.executeUpdate();
            System.out.println("[SQL] DELETE realizado com sucesso!");
        } catch (SQLException e) {
        	throw new RuntimeException(e);
        }
    }

    private Tarefa mapearResultadoParaTarefa(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id");
        String titulo = resultado.getString("titulo");
        String descricao = resultado.getString("descricao");
        return new Tarefa(id, titulo, descricao);
    }
    
}
