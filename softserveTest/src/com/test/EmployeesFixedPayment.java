package com.test;

/**
 * Created by Ravskiy Pavel on 06.04.2017.
 */
public class EmployeesFixedPayment extends Employees {

    public EmployeesFixedPayment(String firstName, String lastName, double salary) {
        super(firstName, lastName, salary);
    }

    @Override
    public double calculateSalary() {
        return 0;
    }

    /*@Override
    public double calculateSalary() {
        return 0;
    }*/
}
