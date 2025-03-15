import data.FileHandler;

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
            selectOption(option);
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

    //retorna a escolha do usuário do menu
    private int getOption() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void selectOption(int option) {
        switch (option) {
            case 1 -> {
                //TODO: CADASTRAR UM NOVO PET
                List<String> questions = FileHandler.getQuestionsFromFile();
                System.out.println("\n===== CADASTRO DE NOVO PET =====");
                for (String question: questions) {
                    System.out.println(question);
                    String answer = scanner.nextLine();
                    System.out.println(answer);
                }
            }
            case 6 -> System.out.println("Saindo...");
            default -> System.out.println("Opção inválida, tente novamente.");
        }
    }
}
