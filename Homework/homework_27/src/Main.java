import ua.com.softsolutions.Company;
import ua.com.softsolutions.Department;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        Company soft = new Company("Soft Solutions");

        soft.addEmployee("development", "23", "Kurt", "Cobain", "4000");
        soft.addEmployee("development", "245", "Kurt", "Cobain", "4000");
        soft.addEmployee("management", "27", "Alex", "Rose", "4700");
        soft.addEmployee("design", "22", "Alice", "Cooper", "3500");
        soft.getAllDepartments();
        soft.getIdEmployeeFromDepartment("development");
    }
}
