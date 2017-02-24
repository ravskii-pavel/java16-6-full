package ua.com.softsolutions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ravskiy on 23.02.2017.
 */
public class App {
    public static void main(String[] args) {
        Company soft = new Company("Soft Solutions");
        Scanner scanner = new Scanner(System.in);
        String result = "";
        while (true){
            String line = scanner.nextLine();
            result = formatLine(line);
            if(line.equalsIgnoreCase("exit")) break;

            if (line.startsWith("add")){
                soft.addEmployee(result.split(" "));
            }
            else if (line.startsWith("get")){
                if (line.contains("all")) {
                    soft.getAllDepartments();
                }
                else if (line.contains("[") && line.contains("]")){
                    //if (line.matches("(.+?)\\[(.+?)"))  //можно без круглых скобок
                    if (line.matches("^(.+?)\\[(.+?)\\[(.+?)$")){
                        soft.getDataEmployeeFromDepartment(result.split(" ")); //!!! поставить рег для split
                    }
                }
            }

        }
    }

    public static String formatLine(String... params) {
        String line = params[0];
        char[] resultLine = line.toCharArray();
        int i =0;
        while(i < resultLine.length){
            if(resultLine[i] == '[' || resultLine[i] == ']'){
                resultLine[i] = ' ';
            }
            i++;
        }
        return new String(resultLine);
    }
}
