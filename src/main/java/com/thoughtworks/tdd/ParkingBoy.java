package com.thoughtworks.tdd;

import java.util.Map;

public class ParkingBoy {


    public Ticket parkCar(Car car){
        return new Ticket(car);
    }

    public Car returnCar(Ticket ticket) {

        Map<Car, Ticket> cars = ParkingLot.getCars();

        for (Car car : cars.keySet()) {
            if(ticket==cars.get(car)){
                return  car;
            }
        }

        return null;
    }
}

