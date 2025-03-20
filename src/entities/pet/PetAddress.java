package entities.pet;

public class PetAddress {
    private String houseNumber;
    private String city;
    private String street;

    public PetAddress(String houseNumber, String city, String street) {
        this.houseNumber = houseNumber;
        this.city = city;
        this.street = street;
    }

    public String formatAddress() {
        return "Rua: "+ this.street + ", " + this.houseNumber+ ", " + this.city;
    }
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
