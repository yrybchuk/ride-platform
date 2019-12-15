package pl.irybchuk.util.query;

import org.joda.time.DateTime;
import pl.irybchuk.model.Address;
import pl.irybchuk.model.Price;
import pl.irybchuk.model.User;
import pl.irybchuk.model.Vehicle;

import java.util.Map;

public final class RentVehicleQuery {

    public static final String insertIntoQuery (Map<String, Object> queryParameters) {
        String query = "INSERT INTO ride_information"
                + " (id_user, id_vehicle, id_startAddress, id_endAddress, start_time, end_time, id_price)"
                + "Values (idUser, idVehicle, idStartAddress, idEndAddress, startTime, endTime, price)";

        User user = (User) queryParameters.get("idUser");
        query.replace("idUser", String.valueOf(user.getId()));

        Vehicle vehicle = (Vehicle) queryParameters.get("idVehicle");
        query.replace("idVehicle", String.valueOf(vehicle.getId()));

        //--------------------------------------------------------
        Address startAddress = (Address) queryParameters.get("idStartAddress");
        query.replace("idStartAddress", String.valueOf(startAddress.getId()));

        query.replace("idEndAddress", "");

        query.replace("startTime", String.valueOf(DateTime.now()));

        query.replace("endTime", "");

        Price price = (Price) queryParameters.get("idPrice");
        query.replace("idPrice",String.valueOf(price.getId()));

        return query;
    }
}
