import ua.com.softsolutions.Company;
import ua.com.softsolutions.Department;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        Company soft = new Company("Soft Solutions");

        soft.addEmployee("development", "23", "Kurt", "Cobain", "4000");
        Department department1 = new Department("Dev");
        Department department2 = new Department("Des");
        Department department3 = new Department("Manager");

        System.out.println();
    }
}
