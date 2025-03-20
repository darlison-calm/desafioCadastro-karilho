    package services.pet;

    import entities.pet.PetAddress;
    import entities.pet.PetModel;
    import enums.PetSex;
    import enums.PetType;

    import java.util.Scanner;

    public class PetService {

        private final Scanner scanner;
        private final String NOT_INFORMED_DATA = "NÃO INFORMADO";

        public PetService(Scanner scanner) {
            this.scanner = scanner;
        }

        public void processPetAnswer(int questionNumber, String answer, PetModel pet) throws Exception {
            switch (questionNumber) {
                case 1:
                    validateName(answer);
                    setPetName(answer, pet);
                    break;
                case 2:
                    PetType petType = validateType(answer);
                    pet.setType(petType);
                    break;
                case 3:
                    PetSex sexPet = validateSex(answer);
                    pet.setSex(sexPet);
                    break;
                case 4:
                    PetAddress address = validateAddress();
                    pet.setAddress(address);
                    break;
                case 5:
                    float petAge = validateAge(answer);
                    pet.setAge(petAge);
                    break;
                case 6:
                    float petWeight = validateWeight(answer);
                    pet.setWeight(petWeight);
                    break;
                case 7:
                    String petBreed = validateBreed(answer);
                    pet.setBreed(petBreed);
                    break;
            }
        }

        private void setPetName(String name, PetModel pet) {
            if (name.trim().isEmpty()) {
                 pet.setName(NOT_INFORMED_DATA);
            }
            pet.setName(name);
        }

        private void validateName(String name) throws Exception {
            boolean isValidPetName = name.trim().matches("[A-Za-z]+ [A-Za-z]+");
            if (!isValidPetName) {
                throw new Exception("Nome e Sobrenome só devem conter letras");
            }
        }

        private PetType validateType(String petType) throws Exception {
            for (PetType type : PetType.values()) {
                if (petType.trim().equalsIgnoreCase(type.getDescription())) {
                   return type;
                }
            }
            throw new Exception("TIPO CACHORRO/GATO - cachorro/gato");
        }

        private PetSex validateSex(String petGender) throws Exception {
            for (PetSex gender : PetSex.values()) {
                if (petGender.trim().equalsIgnoreCase(gender.getDescription())) {
                    return gender;
                }
            }
            throw new Exception("GÊNERO INVÁLIDO - Use 'Macho' ou 'Fêmea'.");
        }
        private PetAddress validateAddress() throws Exception {
            String numberInput;
            String city;
            String street;

            while (true) {
                try {
                    System.out.println("Numero:");
                    numberInput = scanner.nextLine();

                    if (!numberInput.trim().isEmpty()) {
                        Integer.parseInt(numberInput);
                        break;
                    } else {
                        numberInput = NOT_INFORMED_DATA;
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Número inválido. Por favor, digite um número inteiro.");
                }
            }

            while (true) {
                System.out.println("Cidade:");
                city = scanner.nextLine();

                if (!city.trim().isEmpty()) {
                    break;
                } else {
                    System.out.println("A cidade não pode estar vazia. Por favor, tente novamente.");
                }
            }

            while (true) {
                System.out.println("Nome da rua:");
                street = scanner.nextLine();

                if (!street.trim().isEmpty()) {
                    break;
                } else {
                    System.out.println("O nome da rua não pode estar vazio. Por favor, tente novamente.");
                }
            }
            return new PetAddress(numberInput, city, street);
        }

        private float validateAge(String age) throws Exception {
           float petAge = Float.parseFloat(age);
            if (petAge > 240) {
                throw new Exception("Idade não pode ser maior que 20 anos. Idade em meses");
            }
            return petAge/12;
        }

        private float validateWeight(String weight) throws Exception {
            float petWeight = Float.parseFloat(weight);
            if((petWeight > 60) || (petWeight < 0.5)) {
                throw new Exception("PESO NÃO PODE SER MENOR QUE 0.5 OU MAIOR QUE 60");
            }
            return petWeight;
        }

        private String validateBreed(String breed) throws Exception {
            boolean isValidBreed = breed.trim().matches("[A-Za-z ]+");
            if (!isValidBreed) {
                throw new Exception("Raça não pode numeros ou caracteres especiais.");
            }
            return breed;
        }
    }
