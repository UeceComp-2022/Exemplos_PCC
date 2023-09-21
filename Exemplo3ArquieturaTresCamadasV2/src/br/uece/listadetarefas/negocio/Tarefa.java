package br.uece.listadetarefas.negocio;

/**
 * Classe de domínio de negócio
 * @author marcos.eduardo
 */
public class Tarefa {
	
    private int id;
    private String titulo;
    private String descricao;

    // Construtor
    public Tarefa(int id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
    }
    // Construtor
    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Tarefa() {
	}
    
	// Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
