package com.test;

/**
 * Created by Ravskiy Pavel on 06.04.2017.
 */
public abstract class Employees {
    private String firstName;
    private String lastName;
    protected double salary;

    public abstract double calculateSalary();

    public Employees(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }
    public int calculate(){
        double v = salary * 4;
        return (int) v;
    }
}
