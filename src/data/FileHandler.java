
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {

    private static final String ARQUIVO = "src/data/formulario.txt";

    public static void readForm() {
        System.out.println("===== CONTEÚDO DO ARQUIVO " + ARQUIVO + " =====");
        try (BufferedReader file = new BufferedReader(new FileReader(ARQUIVO))) {
            String row;
            while ((row = file.readLine()) != null) {
                System.out.println(row);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

}
