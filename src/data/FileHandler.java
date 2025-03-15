package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FORM = "src/data/formulario.txt";

    public static List<String> getQuestionsFromFile() {
        List<String> questions = new ArrayList<>();
        System.out.println("===== CONTEÚDO DO ARQUIVO " + FORM + " =====");
        try (BufferedReader file = new BufferedReader(new FileReader(FORM))) {
            String row;
            while ((row = file.readLine()) != null) {
                questions.add(row);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return questions;
    }

}
