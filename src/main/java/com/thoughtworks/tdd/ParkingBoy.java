package com.thoughtworks.tdd;

public class ParkingBoy {

    public Ticket parkCar(Car car){
        return new Ticket();
    }

    public Car returnCar(Ticket ticket) {
        return new Car();
    }
}
