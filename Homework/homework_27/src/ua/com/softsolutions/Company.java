package ua.com.softsolutions;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by ravskiy on 21.02.2017.
 */
public class Company {
    String companyName;
    private Map<String, Department<? extends Employee>> map = new HashMap<>();

    public Company(String companyName) {
        this.companyName = companyName;
        Department<Developer> developerDepartment = new Department<>("development");
        map.put(developerDepartment.getNameDepartment(), developerDepartment);

        Department<Manager> managerDepartment = new Department<>("management");
        map.put(managerDepartment.getNameDepartment(), managerDepartment);

        Department<Designer> designDepartment = new Department<>("design");
        map.put(designDepartment.getNameDepartment(), designDepartment);
    }

    public void addEmployee (String... params) {
        String departmentName = params[1];
        Department department = map.get(departmentName);
        if(department == null || params.length < 6){checkToexistsName();}
        else {
            Employee employee = createEmployee(params);
            department.addEmployee(employee.getEmployeeId(), employee);
        }
    }

    private Employee createEmployee(String [] params) {

        switch (params[1]){
            case "development": {
                return new Developer(Integer.parseInt(params[2]), params[3], params[4], Integer.parseInt(params[5]));
            }
            case "management": {
                return new Manager(Integer.parseInt(params[2]), params[3], params[4], Integer.parseInt(params[5]));
            }
            case "design": {
                return new Designer(Integer.parseInt(params[2]), params[3], params[4], Integer.parseInt(params[5]));
            }
        }
        return null;
    }

    public void getAllDepartments() {
        for(String s : map.keySet()){
            System.out.print(s + ", ");
        }
        System.out.println();
    }
    public void getIdEmployeeFromDepartment(String... params) {
        String departmentName = params[1];
        Department department = map.get(departmentName);
        if(department == null) checkToexistsName();
        else department.getIdEmployee();
        System.out.println();
    }
    public void getIdEmployeeFromDepartment2(String... params) {
        String departmentName = params[1];
        Department department = map.get(departmentName);
        if(department == null) checkToexistsName();
        else department.getIdEmployee2();
        System.out.println();
    }
    public void getDataEmployeeFromDepartment(String... params) {
        String departmentName = params[1];
        Department department = map.get(departmentName);
        if(department == null) checkToexistsName();
        else department.getDataEmployee(Integer.parseInt(params[2]));
    }
    private void checkToexistsName(){
        System.out.println("нет такого отдела или неверно введены данные");
    }

}
