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
        try (PreparedStatement stmt = prepararInstrucaoSQL(sql)) {
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Tratar exceções aqui
            e.printStackTrace();
        }
    }

    @Override
    public Tarefa buscarTarefaPorId(int id) {
        String sql = "SELECT * FROM tarefa WHERE id = ?";
        try (PreparedStatement stmt = prepararInstrucaoSQL(sql)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                return mapearResultadoParaTarefa(resultado);
            }
        } catch (SQLException e) {
            // Tratar exceções aqui
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Tarefa> listarTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM tarefa";
        try (PreparedStatement stmt = prepararInstrucaoSQL(sql)) {
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                tarefas.add(mapearResultadoParaTarefa(resultado));
            }
        } catch (SQLException e) {
            // Tratar exceções aqui
            e.printStackTrace();
        }
        return tarefas;
    }

    @Override
    public void atualizarTarefa(Tarefa tarefa) {
        String sql = "UPDATE tarefa SET titulo = ?, descricao = ? WHERE id = ?";
        try (PreparedStatement stmt = prepararInstrucaoSQL(sql)) {
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setInt(3, tarefa.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Tratar exceções aqui
            e.printStackTrace();
        }
    }

    @Override
    public void excluirTarefa(int id) {
        String sql = "DELETE FROM tarefa WHERE id = ?";
        try (PreparedStatement stmt = prepararInstrucaoSQL(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Tratar exceções aqui
            e.printStackTrace();
        }
    }

    /*
     *  A partir daqui seguem os Métodos privados para auxiliar nas operações com o banco de dados
     */
    
    private Tarefa mapearResultadoParaTarefa(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id");
        String titulo = resultado.getString("titulo");
        String descricao = resultado.getString("descricao");
        return new Tarefa(id, titulo, descricao);
    }

    private PreparedStatement prepararInstrucaoSQL(String sql) throws SQLException {
        return conexao.prepareStatement(sql);
    }
    
}
