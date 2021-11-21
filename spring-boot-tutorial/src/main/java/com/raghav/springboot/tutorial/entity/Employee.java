package com.raghav.springboot.tutorial.entity;


public class Employee {
    Address address;

    public Employee(Address accptedAddress) {
        this.address = accptedAddress;
    }
}

class Test {
    public static void main(String[] args) {
        Address address = new Address("Mejestic", 2, 102);
        Employee employee = new Employee(address);
        System.out.println(employee.address);
    }
}