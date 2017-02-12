package model;

public class Main {

    public static void main(String[] args) {

        Employee [] employees = {new Junior(), new Middle(), new Senior()};

        for (Employee emp : employees){
            emp.calculateSalary();
        }


    }
}
