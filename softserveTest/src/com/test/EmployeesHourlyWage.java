package com.test;

/**
 * Created by Ravskiy Pavel on 06.04.2017.
 */
class EmployeesHourlyWage extends Employees {


    public EmployeesHourlyWage(String firstName, String lastName, double salary) {
        super(firstName, lastName, salary);
    }

    @Override
    public double calculateSalary() {
        return 0;
    }
}
