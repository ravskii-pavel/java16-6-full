package ua.com.softsolutions;

/**
 * Created by ravskiy on 21.02.2017.
 */
public class Designer extends Employee {

    public Designer(int employeeId, String firstName, String lastName, double salary) {
        super(employeeId, firstName, lastName, salary);
    }

    @Override
    public int getEmployeeId() {
        return super.getEmployeeId();
    }

    @Override
    public void setEmployeeId(int employeeId) {
        super.setEmployeeId(employeeId);
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public void setSalary(double salary) {
        super.setSalary(salary);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
