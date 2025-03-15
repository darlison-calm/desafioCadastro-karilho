package enums;

public enum PetGender {
    MALE("Macho"),
    FEMALE("Fêmea");

    private final String description;

    public String getDescription() {
        return description;
    }
    PetGender(String description) {
        this.description = description;
    }
}
