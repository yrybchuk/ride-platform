package pl.irybchuk.service;

import org.joda.time.DateTime;
import pl.irybchuk.model.*;
import pl.irybchuk.service.Exception.UserNotAdultException;
import pl.irybchuk.util.ConnectionUtil;
import pl.irybchuk.util.query.RentVehicleQuery;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static pl.irybchuk.model.RideInformation.SELECT_VEHICLES_IN_USE_QUERY;

public class RentVehicleService {

    private ConnectionUtil connectionUtil;

    private static final int AdultAge = 18;
    private static final int ExpiredTime = 10800; //(3 hrs in seconds)

    private Connection connection;

    private  Set<Vehicle> vehicleInUse;

    public RentVehicleService(Set<Vehicle> vehicleInUse) {
        this.connection = ConnectionUtil.getConnection();

        this.vehicleInUse = vehicleInUse;
    }

    private Set<RideInformation> rideInformations = new HashSet<>();



    public  boolean rentVehicle(User user, Vehicle vehicle, Address startAddress, Price price) {

        if (TransportType.CAR == vehicle.getTransportType()) {
            if (!isAdult(user)) {
                String message = "You're not allowed to drive a car";
                //throw new UserNotAdultException(message);
            }
        }

        if (!isVehicleInUse(vehicle))  {
            if (!isUserAllowedToRentVehicle(user)) {
                Map<String, Object> queryMap = new HashMap<>();
                queryMap.put("idUser",user);
                queryMap.put("idVehicle", vehicle);
                queryMap.put("idStartAddress", startAddress);
                queryMap.put("idPrice", price);

                try {
                    Statement statement = this.connection.createStatement();
                    String query = RentVehicleQuery.insertIntoQuery(queryMap);
                    statement.execute(query);

                } catch (SQLException e) {
                    //add logger
                    e.printStackTrace();
                    return false;
                }

            }
        }
        return true;
    }




    public boolean isAdult (User user){
        if (user == null){
            return false;
        }

        Integer yearOfBirth = user.getDoB().getYear();
        return  LocalDate.now().getYear() - yearOfBirth >= AdultAge;
    }

    public boolean isVehicleInUse (Vehicle vehicle){
        boolean inUse = false;

        try {
            Statement statement = this.connection.createStatement();
            String query = SELECT_VEHICLES_IN_USE_QUERY.concat(vehicle.getId().toString());
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.last()){
                String idEndAddress = resultSet.getString("id_endAddress");
                inUse = idEndAddress == null ? true : false;
            }

        } catch (SQLException e) {
            //add logger
            e.printStackTrace();
        }

        return inUse;
//        vehicleInUse.stream()
//                .map(Vehicle::getId)
//                .filter(id -> id.equals(vehicle.getId()))
//                .findFirst()
//                .isPresent();
//
//        return vehicleInUse.contains(vehicle);

    }

    private boolean isUserAllowedToRentVehicle(User user){
        return rideInformations.stream()
                .map(RideInformation::getUser)
                .filter(user1 -> user1.getId().equals(user.getId()))
                .findFirst()
                .isPresent();
    }

    private Set<RideInformation> getExpiredRentedRides(){

        return this.rideInformations.stream()
                .filter(ride -> isRideExpired(ride))
                .collect(Collectors.toSet());

    }

    private boolean isRideExpired (RideInformation rideInformation){
        DateTime currentTime = new DateTime(LocalDateTime.now());
        DateTime startTime = new DateTime(rideInformation.getStartDateTime());
        Long duration = currentTime.getMillis() - startTime.getMillis();
        Long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
        return diffInSeconds >= ExpiredTime;
    }

}
