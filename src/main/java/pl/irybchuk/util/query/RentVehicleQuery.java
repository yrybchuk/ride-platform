package pl.irybchuk.util.query;

import pl.irybchuk.model.Address;
import pl.irybchuk.model.Price;
import pl.irybchuk.model.User;
import pl.irybchuk.model.Vehicle;

import java.util.Map;

public final class RentVehicleQuery {

    public static final String insertIntoQuery (Map<String, Object> queryParameters) {

        String query = "INSERT INTO ride_information"
                + " (id_user, id_vehicle, id_startAddress, start_time, id_price)"
                + " Values (idUser, idVehicle, idStartAddress, startTime, idPrice)";

        User user = (User) queryParameters.get("idUser");
        query = query.replace("idUser", String.valueOf(user.getId()));

        Vehicle vehicle = (Vehicle) queryParameters.get("idVehicle");
        query = query.replace("idVehicle", String.valueOf(vehicle.getId()));

        Address startAddress = (Address) queryParameters.get("idStartAddress");
        query = query.replace("idStartAddress", String.valueOf(startAddress.getId()));

        query = query.replace("startTime", "'2019-09-18 13:45:23'");

        Price price = (Price) queryParameters.get("idPrice");
        query = query.replace("idPrice", String.valueOf(price.getId()));

        return query;
    }
}
