package com.thoughtworks.tdd;

import java.util.Map;

public class ParkingBoy {


    public Ticket parkCar(Car car){
        return new Ticket(car);
    }

    public Car returnCar(Ticket ticket) {

        Map<Car, Ticket> cars = ParkingLot.getCars();
        if(ticket == null){
            ParkingLot.setMessage("Please provide your parking ticket.");
            return null;
        }

        for (Car car : cars.keySet()) {
            if(ticket==cars.get(car)){
                ParkingLot.removeCar(car,ticket);
                return car;
            }
        }
        ParkingLot.setMessage("Unrecognized parking ticket.");
        return null;
    }
}

