package pl.irybchuk.model;

import java.time.LocalDateTime;

public class RideInformation {

    private User user;
    private Vehicle vehicle;
    private Price price;
    private Address startAddress;
    private Address endAddress;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    public static final String SELECT_VEHICLES_IN_USE_QUERY =
            "select id_endAddress from ride_information where id_vehicle =";


    public RideInformation(){
    }

    public RideInformation(User user, Vehicle vehicle, Address startAddress) {
        this.user = user;
        this.vehicle = vehicle;
        this.startAddress = startAddress;
    }

    public RideInformation(User user, Vehicle vehicle, Address startAddress, LocalDateTime startDateTime) {
        this.user = user;
        this.vehicle = vehicle;
        this.startAddress = startAddress;
        this.startDateTime = startDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Address getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(Address startAddress) {
        this.startAddress = startAddress;
    }

    public Address getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(Address endAddress) {
        this.endAddress = endAddress;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
}
