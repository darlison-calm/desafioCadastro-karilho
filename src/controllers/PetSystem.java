package controllers;

import data.FileHandler;
import entities.pet.Pet;
import entities.pet.PetInputValidator;
import enums.PetGender;
import enums.PetType;
import utils.StringUtils;
import java.util.List;
import java.util.Scanner;

public class PetSystem {

    private final Scanner scanner;

    public PetSystem() {
        this.scanner = new Scanner(System.in);
    }

    public void init() {
        int option = 0;
        while (option != 6) {
            showMenu();
            option = getMenuOption();
            selectOptionFromMenu(option);
        }
        scanner.close();
    }

    private void showMenu() {
        System.out.println("\n===== SISTEMA DE GERENCIAMENTO DE PETS =====");
        System.out.println("1. Cadastrar um novo pet");
        System.out.println("2. Alterar os dados do pet cadastrado");
        System.out.println("3. Deletar um pet cadastrado");
        System.out.println("4. Listar todos os pets cadastrados");
        System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção:\n");
    }

    private void insertNewPet() {
        List<String> questions = FileHandler.getQuestionsFromFile();
        System.out.println("\n===== CADASTRO DE NOVO PET =====");
        Pet pet = new Pet();

        for (String question : questions) {
            int questionNumber = StringUtils.getQuestionNumber(question);

            while (true) {
                try {
                    System.out.println(question);
                    String answer = scanner.nextLine();

                    if (answer.equalsIgnoreCase("cancelar")) {
                        System.out.println("Cadastro cancelado.");
                        return;
                    }
                    processPetAnswer(questionNumber, answer, pet);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println(pet.getName() +" " + pet.getName());
    }

    private void processPetAnswer(int questionNumber, String answer, Pet pet) throws Exception {
        switch (questionNumber) {
            case 1:
                if (!PetInputValidator.isValidPetName(answer)) {
                    throw new Exception("Nome do pet inválido deve conter nome e sobrenome (apenas letras).");
                }
                pet.setName(answer);
                break;
            case 2:
                PetType petType = PetInputValidator.validatePetType(answer);
                if (petType == null) {
                    throw new Exception("Resposta inválida: cachorro ou gato");
                }
                pet.setType(petType);
                break;
            case 3:
                PetGender petGender = PetInputValidator.validatePetGender(answer);
                if (petGender == null) {
                    throw new Exception("Resposta inválida: Macho ou Fêmea");
                }
                pet.setGender(petGender);
                break;
            default:
                break;
        }
    }

    //Retorna o número da escolha do usuário do menu
    private int getMenuOption() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void selectOptionFromMenu(int option) {
        switch (option) {
            case 1 -> insertNewPet();
            case 6 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida, tente novamente.");
        }
    }

}
