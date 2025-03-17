package entities.pet;

import enums.PetGender;
import enums.PetType;

public class PetInputValidator {

    public static boolean isValidPetName(String name) {
        if (name == null) {
            return false;
        }
        return name.trim().matches("[A-Za-z]+ [A-Za-z]+");
    }

    public static PetType validatePetType(String petTypeString) {
        for (PetType type : PetType.values()) {
            if (type.getDescription().equalsIgnoreCase(petTypeString)) {
                return type;
            }
        }
        return null;
    }

    public static PetGender validatePetGender(String petGender) {
        for (PetGender gender : PetGender.values()) {
            if (gender.getDescription().equalsIgnoreCase(petGender)) {
                return gender;
            }
        }
        return null;
    }
}
