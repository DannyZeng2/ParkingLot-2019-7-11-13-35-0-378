package com.thoughtworks.tdd;

import java.util.Map;

public class ParkingBoy {




    public Ticket parkCar(Car car,ParkingLot parkingLot){
        Ticket ticket = new Ticket(car);
        parkingLot.addCar(car,ticket);
        return ticket;
    }

    public Ticket parkCarStupid(Car car,ParkingLot parkingLot1,ParkingLot parkingLot2){
        Ticket ticket = new Ticket(car);
        if(parkingLot1.getCars().size()==2){
            parkingLot2.addCar(car,ticket);
        }else {
            parkingLot1.addCar(car,ticket);
        }

        return ticket;
    }

    public Ticket parkCarClever(Car car,ParkingLot parkingLot1,ParkingLot parkingLot2){
        Ticket ticket = new Ticket(car);
        if(parkingLot1.getCars().size()<parkingLot2.getCars().size()&&parkingLot1.getCars().size()!=2){
            parkingLot1.addCar(car,ticket);
        }else{
            parkingLot2.addCar(car,ticket);
        }

        return ticket;
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

