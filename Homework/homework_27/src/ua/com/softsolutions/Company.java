package ua.com.softsolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ravskiy on 21.02.2017.
 */
public class Company {
    String companyName;
    Map<Department, Department> map = new HashMap<>();

    /*String companyName;
    Department <HashMap<Integer, String>> department;
*/
    public Company(String companyName) {
        this.companyName = companyName;
    }

    public void addDepartment(String nameDepartment) {
        Department department = new Department(nameDepartment);
        map.put(department, department);
        /*department = new Department<>(nameDepartment);*/

    }
   /* public void getAll(){
        for (Map.Entry entry : department){

        }
    }*/
}
