package br.uece.file.exemplo;

import java.io.*;

/**
 * Exemplo simples de leitura e escrita de um arquivo de texto.
 * 
 * Obs.: A leitura e escrita de arqruivos binários de texto 
 * não precisam necessariamente estar em um mesmo arquivo.
 * Ficaram juntos somente para facilitar o compartilhamento.
 * 
 *  
 * Dica: Lembre-se de que esses exemplos são simplificados e 
 * não tratam todos os possíveis erros. Ao trabalhar com 
 * arquivos reais, é importante incluir tratamento de exceções e 
 * garantir o fechamento adequado dos fluxos de entrada e saída.
 */
public class ExemploLeituraEscritaArqTexto {
	public static void main(String[] args) {
		
		// Escrever em um arquivo de texto
		try {
			FileWriter writer = new FileWriter("meutxt.uab");
			writer.write("Exemplo de escrita em arquivo de texto.");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Ler de um arquivo de texto
		try {
			FileReader reader = new FileReader("meutxt.uab");
			int character;
			while ((character = reader.read()) != -1) {
				System.out.print((char) character);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
