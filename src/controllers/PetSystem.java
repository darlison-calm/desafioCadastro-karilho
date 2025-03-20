package controllers;

import data.FileHandler;
import entities.pet.PetModel;
import services.pet.PetService;
import utils.StringUtils;

import java.util.List;
import java.util.Scanner;

public class PetSystem {
    private final String NOT_INFORMED_DATA = "NÃO INFORMADO";
    private final Scanner scanner;
    private final PetService petService;

    public PetSystem() {
        this.scanner = new Scanner(System.in);
        this.petService = new PetService(scanner);
    }

    public void init() {
        int option = 0;
        FileHandler.createPetsDirectory();
        while (option != 6) {
            showMenu();
            option = getMenuOption();
            selectOptionFromMenu(option);
        }
        scanner.close();
    }

    private void showMenu() {
        System.out.println("| 1 - Cadastrar um novo pet                            |");
        System.out.println("| 2 - Alterar dados de um pet cadastrado               |");
        System.out.println("| 3 - Deletar um pet cadastrado                        |");
        System.out.println("| 4 - Listar todos os pets cadastrados                 |");
        System.out.println("| 5 - Listar pets por algum critério (idade,nome,raça) |");
        System.out.println("| 6 - Sair                                             |");
        System.out.print("Digite: ");
    }

    private void insertNewPet() {
        List<String> questions = FileHandler.getQuestionsFromFile();
        System.out.println("\n===== CADASTRO DE NOVO PET =====");
        PetModel pet = new PetModel();

        int questionsCount = questions.size();
        for (int i = 0; i < questionsCount; i++) {
            int questionNumber = StringUtils.getQuestionNumber(questions.get(i));

            while (true) {
                try {
                    System.out.println(questions.get(i));
                    String answer = "";

                    if (i == 2) {
                        System.out.println("Macho ou Fêmea:");
                    }

                    if (i != 3) {
                        answer = scanner.nextLine();
                    }

                    if (answer.equalsIgnoreCase("cancelar")) {
                        System.out.println("Cadastro cancelado.");
                        return;
                    }
                    petService.processPetAnswer(questionNumber, answer, pet);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        FileHandler.createPetFile(pet);
    }

    //Retorna o número da escolha do usuário do menu
    private void selectOptionFromMenu(int option) {
        switch (option) {
            case 1 -> insertNewPet();
            case 6 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida, tente novamente.");
        }
    }

    private int getMenuOption() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}