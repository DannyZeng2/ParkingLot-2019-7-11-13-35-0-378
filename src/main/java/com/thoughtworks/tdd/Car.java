package com.thoughtworks.tdd;

public class Car {
    private String id;
    private String brand;
    private String color;
    private Ticket ticket;

    public Car(Ticket ticket) {
        this.ticket = ticket;
    }

    public Car(String id, String brand, String color) {
        this.id = id;
        this.brand = brand;
        this.color = color;
    }
}
