package pl.irybchuk;

import pl.irybchuk.model.*;
import pl.irybchuk.service.RentVehicleService;

import java.math.BigDecimal;

public class Runner {

    public static void main(String[] args){
        RentVehicleService rentVehicleService = new RentVehicleService(null);

        User user = new User(1,"Iaroslav","Rybchuk", null);
        Vehicle vehicle = new Vehicle(TransportType.BICYCLE, 5, "Tesla");
        Address address = new Address(1,"Warsaw","Jana Pawla");
        Price price = new Price(1,PriceUnit.MINUTE, BigDecimal.valueOf(10),"USD");


        rentVehicleService.rentVehicle(user,vehicle,address,price);



    }


}
