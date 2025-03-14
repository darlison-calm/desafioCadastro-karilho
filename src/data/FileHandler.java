package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {

    private static final String FORM = "src/data/formulario.txt";

    public static void readForm() {
        System.out.println("===== CONTEÚDO DO ARQUIVO " + FORM + " =====");
        try (BufferedReader file = new BufferedReader(new FileReader(FORM))) {
            String row;
            while ((row = file.readLine()) != null) {
                System.out.println(row);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

}
