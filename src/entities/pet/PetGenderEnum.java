package entities.pet;

public enum PetGenderEnum {
    MALE("Macho"),
    FEMALE("Fêmea");

    private final String description;

    public String getDescription() {
        return description;
    }

    PetGenderEnum(String description) {
        this.description = description;
    }


}
