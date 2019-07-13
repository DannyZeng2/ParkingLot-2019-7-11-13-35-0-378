package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private Map<Car,Ticket> cars = new HashMap();
    private int maxCapacity = 2;
    private String Message;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }



    public void addCar(Car car,Ticket ticket) {

        if(cars.size()<maxCapacity) {
            cars.put(car,ticket);
        }else {
            setMessage("Not enough position.");
        }
    }

    public void removeCar(Car car,Ticket ticket) {
        cars.remove(car,ticket);
    }

    public Map<Car, Ticket> getCars() {
        return cars;
    }
}
