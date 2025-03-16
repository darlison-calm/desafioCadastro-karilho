import data.FileHandler;
import entities.pet.PetInputValidator;
import utils.StringUtils;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void init() {
        int option = 0;
        while (option != 6) {
            showMenu();
            option = getOption();
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

    //Retorna o número da escolha do usuário do menu
    private int getOption() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void selectOptionFromMenu(int option) {
        switch (option) {
            case 1 -> {
                insertNewPet();
            }
            case 6 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida, tente novamente.");
        }
    }

    private void checkAnswerInput(int questionNumber, String answer) throws Exception {
        switch (questionNumber) {
            case 1:
                if (!PetInputValidator.validatePetName(answer)) {
                    throw new Exception("Nome do pet inválido deve conter nome e sobrenome (apenas letras).");
                }
                break;
            default:
                break;
        }
    }

    private void insertNewPet() {
        List<String> questions = FileHandler.getQuestionsFromFile();
        System.out.println("\n===== CADASTRO DE NOVO PET =====");

        for (String question : questions) {
            int questionNumber = StringUtils.getQuestionNumber(question);
            String answer;
            while (true) {
                try {
                    System.out.println(question);
                    answer = scanner.nextLine();

                    if (answer.equalsIgnoreCase("cancelar")) {
                        System.out.println("Cadastro cancelado.");
                        return;
                    }
                    checkAnswerInput(questionNumber, answer);
                    System.out.println("Resposta:" + answer);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
