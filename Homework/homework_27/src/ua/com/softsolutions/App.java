package ua.com.softsolutions;

import java.util.Scanner;

/**
 * Created by ravskiy on 23.02.2017.
 */
public class App {
    public static void main(String[] args) {
        Company soft = new Company("Soft Solutions");
        Scanner scanner = new Scanner(System.in);

        while (true){

            String line = scanner.nextLine();
            if(line.equalsIgnoreCase("exit")) break;

            if (line.startsWith("add")){
                soft.addEmployee(line.split(" "));
            }
            else if (line.startsWith("get all")){
                soft.getAllDepartments();
                System.out.println();
            }
            else if(){
                
            }
        }
    }
}
