package entities.pet;

import enums.PetGender;
import enums.PetType;

public class Pet {
    private PetAddress address;
    private String name;
    private Integer age;
    private Float weight;
    private String breed;
    private PetGender gender;
    private PetType type;
    public Pet() {

    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetGender getGender() {
        return gender;
    }

    public void setGender(PetGender gender) {
        this.gender = gender;
    }
}


