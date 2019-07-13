package com.thoughtworks.tdd;

import java.util.Map;

public class ParkingBoy {




    public Ticket parkCar(Car car){
        return new Ticket(car);
    }

    public Car returnCar(Ticket ticket,ParkingLot parkingLot) {
        Map<Car, Ticket> cars = parkingLot.getCars();
        if(ticket == null){
            parkingLot.setMessage("Please provide your parking ticket.");
            return null;
        }

        for (Car car : cars.keySet()) {
            if(ticket==cars.get(car)){
                parkingLot.removeCar(car,ticket);
                return car;
            }
        }
        parkingLot.setMessage("Unrecognized parking ticket.");
        return null;
    }
}

