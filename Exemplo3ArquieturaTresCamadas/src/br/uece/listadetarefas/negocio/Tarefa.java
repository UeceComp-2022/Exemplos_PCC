package br.uece.listadetarefas.negocio;

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
