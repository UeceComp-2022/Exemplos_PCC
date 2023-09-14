// Pacote aplicacao
package br.uece.listadetarefas.aplicacao.portas.entrada;

import java.util.Scanner;

/**
 * Interface java como porta de entrada hexagonal
 */
public interface CasoDeUsoManterTarefa {

	void listarTarefas();

	void criarTarefa(Scanner scanner);

	void atualizarTarefa(Scanner scanner);

	void removerTarefa(Scanner scanner);

}


