package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private static Map<Car,Ticket> cars = new HashMap();
//    private static int maxCapacity = 10;
//    private static int capacity;
//
//
//    public int getCapacity() {
//        return capacity;
//    }
//
//    public static void setCapacity() {
//        if(capacity<maxCapacity){
//            capacity++;
//        }else{
//            System.out.println("full");
//        }
//
//    }

    public static void addCar(Car car,Ticket ticket) {
        cars.put(car,ticket);
    }

    public static Map<Car, Ticket> getCars() {
        return cars;
    }
}
