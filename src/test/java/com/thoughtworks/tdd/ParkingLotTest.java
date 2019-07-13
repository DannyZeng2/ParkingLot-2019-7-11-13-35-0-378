package com.thoughtworks.tdd;

import org.junit.jupiter.api.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ParkingLotTest {

    @Test
    public void should_park_a_car_and_get_a_ticket() {
        //Given
        Car car  = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        //When
        Ticket ticket = parkingBoy.parkCar(car);
        //Then
        Assertions.assertNotNull(ticket);
    }

    @Test
    public void should_give_a_ticket_and_get_a_car() {
        //Given
        Ticket ticket = new Ticket();
        ParkingBoy parkingBoy = new ParkingBoy();
        //When
        Car car = parkingBoy.returnCar(ticket);
        //Then
        Assertions.assertNotNull(car);
    }

}
