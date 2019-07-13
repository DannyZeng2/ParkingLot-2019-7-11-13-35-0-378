package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private static Map<Car,Ticket> cars = new HashMap();
    private static int maxCapacity = 2;

    public static String addCar(Car car,Ticket ticket) {
        if(cars.size()<maxCapacity) {
            cars.put(car, ticket);
            return  "The capacity is not full";
        }else {
            return  "The capacity is full,you can't park here";
        }
    }

    public static void removeCar(Car car,Ticket ticket) {
        cars.remove(car,ticket);
    }

    public static Map<Car, Ticket> getCars() {
        return cars;
    }
}
