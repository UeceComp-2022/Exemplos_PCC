package br.uece.file.exemplo;
import java.io.*;

/**
 * Neste exemplo, a string é escrita no arquivo usando o método writeUTF(), 
 * que armazena a string usando um formato UTF-8 modificado para arquivos 
 * binários. A mesma string é lida posteriormente usando readUTF().
 * 
 * Dica: Lembre-se sempre de tratar as exceções de maneira 
 * adequada em um cenário real,e fechar os fluxos de 
 * entrada/saída corretamente.
 */
public class ExemploLeituraEscritaArqBinario {
    public static void main(String[] args) {
        String content = "Conteúdo da string a ser armazenado no arquivo binário.";

        // Escrever a string em um arquivo binário
        try {
            FileOutputStream fos = new FileOutputStream("string_binaria.bin");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(content);
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ler a string de um arquivo binário
        try {
            FileInputStream fis = new FileInputStream("string_binaria.bin");
            DataInputStream dis = new DataInputStream(fis);
            String readContent = dis.readUTF();
            dis.close();
            System.out.println("Conteúdo lido do arquivo: " + readContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
