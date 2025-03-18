package controllers;

import data.FileHandler;
import entities.pet.PetAddress;
import entities.pet.PetModel;
import services.pet.PetInputValidator;
import enums.PetGender;
import enums.PetType;
import utils.StringUtils;
import java.util.List;
import java.util.Scanner;

public class PetSystem {
    private final String NOT_INFORMED_DATA = "NÃO INFORMADO";
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
        System.out.println("========================================================");
        System.out.println("| 1 - Cadastrar um novo pet                            |");
        System.out.println("| 2 - Alterar dados de um pet cadastrado               |");
        System.out.println("| 3 - Deletar um pet cadastrado                        |");
        System.out.println("| 4 - Listar todos os pets cadastrados                 |");
        System.out.println("| 5 - Listar pets por algum critério (idade,nome,raça) |");
        System.out.println("| 6 - Sair                                             |");
        System.out.println("========================================================");
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

                    if (i != 3) {
                        answer = scanner.nextLine();
                    }
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
    }

    private void processPetAnswer(int questionNumber, String answer, PetModel pet) throws Exception {
        switch (questionNumber) {
            case 1:
                if (answer.trim().isEmpty()) {
                    pet.setName(NOT_INFORMED_DATA);
                } else if (!PetInputValidator.isValidPetName(answer)) {
                    throw new Exception("Nome do pet inválido: deve conter nome e sobrenome (apenas letras).");
                } else {
                    pet.setName(answer);
                }
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
            case 4:
                if (!processAddressInput(pet)) {
                    throw new Exception("Cadastro cancelado pelo usuário");
                }
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

    private boolean processAddressInput(PetModel pet) {
        while (true) {
            try {
                System.out.println("Numero:");
                String numberInput = scanner.nextLine();

                if (numberInput.equalsIgnoreCase("cancelar")) {
                    System.out.println("Cadastro cancelado.");
                    return false;
                }

                // Valida se o número da casa é realmente um número (se fornecido)
                if (!numberInput.trim().isEmpty()) {
                   Integer.parseInt(numberInput);
                   // Se o campo estiver vazio, define como "Não informado"
                } else {
                    numberInput = NOT_INFORMED_DATA;
                }

                System.out.println("Cidade:");
                String city = scanner.nextLine();

                if (city.equalsIgnoreCase("cancelar")) {
                    System.out.println("Cadastro cancelado.");
                    return false;
                }

                if (city.trim().isEmpty()) {
                    System.out.println("Cidade não pode estar vazia.");
                    continue;
                }

                System.out.println("Nome da rua:");
                String street = scanner.nextLine();

                if (street.equalsIgnoreCase("cancelar")) {
                    System.out.println("Cadastro cancelado.");
                    return false;
                }

                if (street.trim().isEmpty()) {
                    System.out.println("Nome da rua não pode estar vazio.");
                    continue;
                }

                PetAddress address = new PetAddress(numberInput, city, street);
                pet.setAddress(address);
                return true;
            } catch (NumberFormatException e) {
                System.out.println("Número inválido. Por favor, digite um número inteiro.");
            }
        }
    }
}