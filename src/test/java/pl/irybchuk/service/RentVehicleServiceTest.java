package pl.irybchuk.service;

import org.junit.Before;
import org.junit.Test;
import pl.irybchuk.model.*;
import pl.irybchuk.service.Exception.UserNotAdultException;
import pl.irybchuk.service.RentVehicleService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static pl.irybchuk.model.TransportType.CAR;

public class RentVehicleServiceTest {

    private RentVehicleService rentVehicleService;
    private Set<Vehicle> vehicles;

//    @Before
//    public void SetUp(){
//        Vehicle testVehicle = createTestVehicle(CAR,"Model Test");
//
//        this.vehicles = new HashSet<>();
//        this.vehicles.add(testVehicle);
//    };


    @Test
    public void isAdult_whenUserIsEighteenOrMore_shouldReturnTrue() {
        //given
        this.rentVehicleService = new RentVehicleService(vehicles);

        User testUser01 = new User("Name01","LastName01", LocalDate.of(1990,10,17));

        //when
        boolean result = this.rentVehicleService.isAdult(testUser01);

        //then
        assertEquals(true,result);

    }

    @Test
    public void isAdult_whenUserIsLessEighteen_shouldReturnFalse() {
        //given
        this.rentVehicleService = new RentVehicleService(vehicles);

        //when
        User testUser01 = new User("Name01","LastName01", LocalDate.of(2010,10,17));

        boolean result = this.rentVehicleService.isAdult(testUser01);
        assertThat(result, is(false));
        //assertEquals(false, result);
    }

    @Test
    public void isAdult_whenUserIsNull_shouldReturnFalse() {
        //given
        this.rentVehicleService = new RentVehicleService(vehicles);
        final User testUser01 = null;

        //when
        boolean result = this.rentVehicleService.isAdult(testUser01);

        //then
        assertEquals(false, result);
    }


//    @Test
//    public void rentVehicle_whenCorrectInputData_thenVehicleIsRent() {
//
//        //given
//        this.rentVehicleService = new RentVehicleService(vehicles);
//        User testUser01 = new User("Name01","LastName01", LocalDate.of(2010,10,17));
//        Vehicle testVehicle01 = new Vehicle(CAR,"001", "Tesla X");
//        Address testAddress01 = new Address("Warsaw","Slominskiego");
//
//        //when
//        RideInformation result = new RideInformation(testUser01,testVehicle01,testAddress01, LocalDateTime.now());
//        LocalDate startDate = result.getStartDateTime().toLocalDate();
//
//        //then
//        assertNotNull(result);
//        assertNotNull(result.getStartDateTime());
//        assertThat(startDate, is(LocalDate.now()));
//
//    }
//
//    @Test(expected = UserNotAdultException.class)
//    public void rentVehicle_whenUserIsNotAdult_thenThrowException() throws UserNotAdultException {
//
//        //given
//        this.rentVehicleService = new RentVehicleService(vehicles);
//        User testUser01 = new User("Name01","LastName01", LocalDate.of(2010,10,17));
//        Vehicle testVehicle01 = new Vehicle(CAR,"001", "Tesla X");
//
//        //when
//        this.rentVehicleService.rentVehicle(testUser01,testVehicle01,null);
//
//    }
//
//    @Test
//    public void isVehicleInUse_whenVehicleBusy_shouldReturnTrue() {
//
//        //given
//        Vehicle testVehicle = new Vehicle(CAR,"001","Tesla");
//        Set<Vehicle> testVehicles = new HashSet<>();
//        testVehicles.add(testVehicle);
//
//        this.rentVehicleService = new RentVehicleService(testVehicles);
//
//        //when
//        boolean result = this.rentVehicleService.isVehicleInUse(testVehicle);
//
//        //then
//        assertEquals(true,result);
//    }

//    @Test
//    public void rentVehicleService_whenParametersGiven_shouldReturnRideInformation() throws UserNotAdultException{
//
//        //given
//        User testUser01 = new User("Name01","LastName01", LocalDate.of(1994,10,17));
//        Vehicle testVehicle01 = new Vehicle(CAR,"001", "Tesla X");
//        Address testAddress = new Address("Warsaw","Slominskiego");
//
//        this.rentVehicleService = new RentVehicleService(vehicles);
//        //when
//
//        RideInformation result = this.rentVehicleService.rentVehicle(testUser01,testVehicle01,testAddress);
//        //then
//        assertNotNull(result);
//        assertNotNull(result.getUser());
//
//    }
//
//    private Vehicle createTestVehicle(TransportType transportType, String model){
//        Vehicle testVehicle = new Vehicle();
//        testVehicle.setTransportType(transportType);
//        testVehicle.setId(model);
//        return testVehicle;
//    }

}