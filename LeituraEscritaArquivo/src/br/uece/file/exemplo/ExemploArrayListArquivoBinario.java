package br.uece.file.exemplo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Neste exemplo, o ArrayList é armazenado no arquivo 
 * usando ObjectOutputStream, que permite serializar e 
 * salvar objetos em formato binário. Ao recuperar o conteúdo 
 * do arquivo, o ObjectInputStream é usado para desserializar o 
 * ArrayList e recuperar os dados originais. 
 */
public class ExemploArrayListArquivoBinario {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Item 1");
        arrayList.add("Item 2");
        arrayList.add("Item 3");

        // Armazenar o ArrayList em um arquivo binário
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream("arraylist.bin");
            oos = new ObjectOutputStream(fos);
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
            FileInputStream fis = new FileInputStream("arraylist.bin");
            ois = new ObjectInputStream(fis);
            List<String> readArrayList = (List<String>) ois.readObject();
            
            // Exibir o conteúdo recuperado
            for (String item : readArrayList) {
                System.out.println("Item: " + item);
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
