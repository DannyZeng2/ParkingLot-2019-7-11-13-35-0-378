package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private static Map<Car,Ticket> cars = new HashMap();
    private static int maxCapacity = 2;
    private static String Message;

    public static String getMessage() {
        return Message;
    }

    public static void setMessage(String message) {
        Message = message;
    }



    public void addCar(Car car,Ticket ticket) {
        if(cars.size()<maxCapacity) {
            cars.put(car, ticket);
        }else {
            setMessage("Not enough position.");
        }
    }

    public static void removeCar(Car car,Ticket ticket) {
        cars.remove(car,ticket);
    }

    public static Map<Car, Ticket> getCars() {
        return cars;
    }
}
