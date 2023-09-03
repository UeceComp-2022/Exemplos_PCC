package br.uece.file.exemplo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import br.uece.file.exemplo.dominio.Aluno;

/**
 * Neste exemplo, o ArrayList é armazenado no arquivo 
 * usando ObjectOutputStream, que permite serializar e 
 * salvar objetos em formato binário. Ao recuperar o conteúdo 
 * do arquivo, o ObjectInputStream é usado para desserializar o 
 * ArrayList e recuperar os dados originais. 
 */
public class ExemploArrayListArquivoBinario {
    public static void main(String[] args) {
        ArrayList<Aluno> arrayList = new ArrayList<>();
        arrayList.add(new Aluno("Maria"));
        arrayList.add(new Aluno("João"));
        arrayList.add(new Aluno("Cristina"));

        // Armazenar o ArrayList em um arquivo binário
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("alunos.bin");
            oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(arrayList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Fechar o ObjectOutputStream no bloco finally 
        	//para garantir que recursos sejam liberados.
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Recuperar o ArrayList do arquivo binário
        ObjectInputStream ois = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("alunos.bin");
            ois = new ObjectInputStream(fileInputStream);
            List<Aluno> readArrayList = (List<Aluno>) ois.readObject();
            
            // Exibir o conteúdo recuperado
            for (Aluno item : readArrayList) {
                System.out.println("Aluno: " + item.getNome());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Fechar o ObjectInputStream no bloco finally 
        	//para garantir que recursos sejam liberados.
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
