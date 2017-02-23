package ua.com.softsolutions;
//package ua.com.softsolutions.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ravskiy on 21.02.2017.
 */
public class Department <T>{
    private final String nameDepartment;
    public Map<Integer, T> map = new HashMap<>();

    public Department(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public Map<Integer, T> getMap() {
        return map;
    }

    public void addEmployee(int employeeId, T employee) {
        map.put(employeeId, employee);
    }
    public void getIdEmployee() {
        for(Integer i : map.keySet()){
            System.out.print(i + ", ");
        }
    }
    public void getIdEmployee2() {
        for(T val : map.values()){
            System.out.print(((Employee)val).employeeId + ", ");     //Employee emp = (Employee) val;   //System.out.print(emp.employeeId + ", ");
        }
        /*for(Map.Entry entry : map.entrySet()){
            System.out.print(entry.getValue() + ", ");
        }*/
    }
    public void getDataEmployee(int idEmployee) {
        for(T val : map.values()){
            if (idEmployee == ((Employee)val).employeeId){
                System.out.println(((Employee)val).toString());     //Employee emp = (Employee) val;   //System.out.print(emp.employeeId + ", ");
            }
        }
    }
}
