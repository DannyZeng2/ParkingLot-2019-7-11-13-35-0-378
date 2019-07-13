package com.thoughtworks.tdd;

import org.junit.jupiter.api.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ParkingLotTest {

    @Test
    public void should_park_a_car_return_get_a_ticket() {
        //Given
        Car car  = new Car("111","丰田","white");
        ParkingBoy parkingBoy = new ParkingBoy();
        //When
        Ticket ticket = parkingBoy.parkCar(car);
        //Then
        Assertions.assertNotNull(ticket);
    }

    @Test
    public void should_get_a_ticket_and_return_a_car() {
        //Given
        Ticket ticket = new Ticket(new Car("111","丰田","white"));
        ParkingBoy parkingBoy = new ParkingBoy();
        //When
        Car car = parkingBoy.returnCar(ticket);
        //Then
        Assertions.assertNotNull(car);
    }

    @Test
    public void should_return_cars_with_correspond_ticket() {
        //Given
        Car car1  = new Car("111","丰田","white");
        Car car2  = new Car("222","本田","black");

        Ticket ticket1 = new Ticket(car1);
        Ticket ticket2 = new Ticket(car2);

        //When
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addCar(car1,ticket1);
        parkingLot.addCar(car2,ticket2);

        //Then
        Assertions.assertEquals(car1,parkingBoy.returnCar(ticket1));
        Assertions.assertEquals(car2,parkingBoy.returnCar(ticket2));

    }

    @Test
    public void should_not_return_cars_with_wrong_or_no_ticket() {
        //Given
        Car car1  = new Car("111","丰田","white");

        Ticket ticket1 = new Ticket(car1);
        Ticket wrongTicket = new Ticket(new Car());

        //When
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addCar(car1,ticket1);

        //Then
        Assertions.assertEquals(null,parkingBoy.returnCar(wrongTicket)); // wrong ticket
        Assertions.assertEquals(null,parkingBoy.returnCar(null)); // no ticket

    }

}
