package pl.irybchuk.model;

public class Address {
    private Integer id;
    private String city;
    private String street;

    public Address(Integer id, String city, String street) {
        this.id = id;
        this.city = city;
        this.street = street;
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
