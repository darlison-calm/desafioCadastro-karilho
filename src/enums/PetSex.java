package enums;

public enum PetSex {
    MALE("Macho"),
    FEMALE("Fêmea");

    private final String description;

    public String getDescription() {
        return description;
    }
    PetSex(String description) {
        this.description = description;
    }
}
