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

    public void setMap(Map<Integer, T> map) {
        this.map = map;
    }

    public void addEmployee(T employee){
        Integer integer = 2;
        map.put(integer,employee);
    }

}
