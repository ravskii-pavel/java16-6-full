package ua.com.softsolutions;

/**
 * Created by ravskiy on 21.02.2017.
 */
public abstract class Employee {
    int employeeId ;
    String firstName;
    String lastName;
    double salary;

    public Employee(int employeeId, String firstName, String lastName, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }
}
