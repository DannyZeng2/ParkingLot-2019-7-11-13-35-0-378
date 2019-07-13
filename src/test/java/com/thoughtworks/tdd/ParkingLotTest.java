package com.thoughtworks.tdd;

import org.junit.jupiter.api.*;


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
        Car car = new Car("111", "丰田", "white");
        Ticket ticket = new Ticket(car);
        ParkingBoy parkingBoy = new ParkingBoy();
        //When
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addCar(car,ticket);

        //Then
        Assertions.assertNotNull(parkingBoy.returnCar(ticket,parkingLot));
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
        Assertions.assertEquals(car1,parkingBoy.returnCar(ticket1,parkingLot));
        Assertions.assertEquals(car2,parkingBoy.returnCar(ticket2,parkingLot));

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
        Assertions.assertEquals(null,parkingBoy.returnCar(wrongTicket,parkingLot)); // wrong ticket
        Assertions.assertEquals(null,parkingBoy.returnCar(null,parkingLot)); // no ticket

    }

    @Test
    public void should_not_return_cars_if_ticket_used() {
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

        Car returnCar1 = parkingBoy.returnCar(ticket1,parkingLot); //ticket1 has been used!!!
        Car returnCar2 = parkingBoy.returnCar(ticket1,parkingLot);

        //Then
        Assertions.assertEquals(car1,returnCar1);
        Assertions.assertEquals(null,returnCar2);

    }

    @Test
    public void should_not_park_cars_if_capacity_is_full() {
        //Given
        Car car1  = new Car("111","丰田","white");
        Car car2  = new Car("222","本田","black");
        Car car3  = new Car("333","宝马","blue");

        Ticket ticket1 = new Ticket(car1);
        Ticket ticket2 = new Ticket(car2);
        Ticket ticket3 = new Ticket(car3);

        //When
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addCar(car1,ticket1);
        parkingLot.addCar(car2,ticket2);
        parkingLot.addCar(car3,ticket3);

        //Then
        Assertions.assertEquals( "Not enough position.",parkingLot.getMessage());


    }
    @Test
    public void should_sent_massage_when_sent_wrong_ticket() {
        //Given
        Car car1  = new Car("111","丰田","white");

        Ticket ticket1 = new Ticket(car1);
        Ticket wrongTicket = new Ticket(new Car());

        //When
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addCar(car1,ticket1);
        parkingBoy.returnCar(wrongTicket,parkingLot);

        //Then
        Assertions.assertEquals("Unrecognized parking ticket.",parkingLot.getMessage()); // wrong ticket
    }

    @Test
    public void should_sent_massage_when_not_provide_ticket() {
        //Given
        Car car1  = new Car("111","丰田","white");
        Ticket ticket1 = new Ticket(car1);

        //When
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addCar(car1,ticket1);

        parkingBoy.returnCar(null,parkingLot);

        //Then
        Assertions.assertEquals("Please provide your parking ticket.",parkingLot.getMessage()); // no ticket
    }

//    @Test
//    public void should_park_car_to_second_position_when_first_parking_lot is full() {
//        //Given
//        Car car1  = new Car("111","丰田","white");
//        Ticket ticket1 = new Ticket(car1);
//
//        //When
//        ParkingBoy parkingBoy = new ParkingBoy();
//        ParkingLot parkingLot1 = new ParkingLot();
//        ParkingLot parkingLot2 = new ParkingLot();
//        parkingLot.addCar(car1,ticket1);
//
//        parkingBoy.returnCar(null,parkingLot);
//
//        //Then
//        Assertions.assertEquals("Please provide your parking ticket.",parkingLot.getMessage()); // no ticket
//    }

}
