package pl.irybchuk.model;

public class Vehicle {
    private TransportType transportType;
    private Integer Id;
    String model;

    public Vehicle(TransportType transportType, Integer id, String model) {
        this.transportType = transportType;
        Id = id;
        this.model = model;
    }



    public Vehicle(TransportType transportType, String model) {
        this.transportType = transportType;
        this.model = model;
    }

    public Vehicle() {

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }
}
