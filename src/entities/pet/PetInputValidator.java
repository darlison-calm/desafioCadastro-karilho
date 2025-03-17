package entities.pet;

import enums.PetType;

public class PetInputValidator {

    public static boolean isValidPetName(String name) {
        if (name == null) {
            return false;
        }
        return name.trim().matches("[A-Za-z]+ [A-Za-z]+");
    }

    public static boolean isValidPetType(String petType) {
        return petType.equalsIgnoreCase(PetType.CAT.getDescription()) ||
                petType.equalsIgnoreCase(PetType.DOG.getDescription());
    }

}
