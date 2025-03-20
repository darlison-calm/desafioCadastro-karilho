package entities.pet;

import enums.PetSex;
import enums.PetType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PetModel {
    private PetAddress address;
    private String name;
    private Float age;
    private Float weight;
    private String breed;
    private PetSex sex;
    private PetType type;
    private final LocalDateTime creationDate;
    public PetModel() {
        this.creationDate = LocalDateTime.now();
    };

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public PetAddress getAddress() {
        return address;
    }

    public void setAddress(PetAddress address) {
        this.address = address;
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

    public PetSex getSex() {
        return sex;
    }

    public void setSex(PetSex gender) {
        this.sex = gender;
    }

    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}


