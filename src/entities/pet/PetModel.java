package entities.pet;

import enums.PetSex;
import enums.PetType;

public class PetModel {
    private PetAddress address;
    private String name;
    private Float age;
    private Float weight;
    private String breed;
    private PetSex gender;
    private PetType type;
    public PetModel() {

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
        return gender;
    }

    public void setSex(PetSex gender) {
        this.gender = gender;
    }


    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }
}


