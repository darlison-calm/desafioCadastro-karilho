package data;

import entities.pet.PetModel;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandler {

    private static final String FORM = "src/data/formulario.txt";
    private static final String PET_DIRECTORY = "src/petsCadastrados";

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

    public static void createPetsDirectory() {
        try {
            Files.createDirectories(Paths.get(PET_DIRECTORY));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static ArrayList<Object> getFileContent(PetModel pet) {
        return new ArrayList<>(Arrays.asList(
                pet.getName(),
                pet.getType().getDescription(),
                pet.getSex().getDescription(),
                pet.getAddress().formatAddress(),
                pet.getAge() + "ano",
                pet.getWeight()+"kg",
                pet.getBreed()
        ));
    }

    public static String getFileTitle(PetModel pet) {
        LocalDateTime dateCreation = pet.getCreationDate();
        String petName = pet.getName().toUpperCase().replaceAll("\\s", "");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        return dateCreation.format(formatter)+"-"+petName;
    }

    public static void createPetFile(PetModel pet) {
        ArrayList<Object> content = getFileContent(pet);
        int contentSize = content.size();
        try  {
            BufferedWriter writer = new BufferedWriter(new FileWriter(PET_DIRECTORY+"/"+getFileTitle(pet)));
            for (int i = 0; i < contentSize; i++) {
                writer.write((i + 1) + " - " + content.get(i));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
