package entities.pet;

public class PetInputValidator {

    public static boolean validatePetName(String name) {
        if (name == null) {
            return false;
        }
        return name.matches("(?i)[ \n]+[a-zA-Z]+");
    }
}
