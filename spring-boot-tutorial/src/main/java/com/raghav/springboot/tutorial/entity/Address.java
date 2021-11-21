package com.raghav.springboot.tutorial.entity;

public class Address {
    String areaName;
    int crossNumber;
    int doorNumber;

    public Address(String areaName, int crossNumber, int doorNumber) {
        this.areaName = areaName;
        this.crossNumber = crossNumber;
        this.doorNumber = doorNumber;
    }
}
