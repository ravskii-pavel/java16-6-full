package calculator;

import java.util.Objects;

public class ArithmeticalOperations {

    public static Object setType(String s1){
        if (s1.contains(".")){
                return Double.parseDouble(s1);
        }
        else {
            return Integer.parseInt(s1);
        }
    }
    public static Object setType(Object s1){
        String str = Objects.toString(s1);
        return Double.parseDouble(str);
    }
    public static Object setTypeInt(Object s1){
        Object result = (Integer) s1;
        return result;
    }

    public static String getResult(String operator, Object a, Object b){
        switch (operator) {
            case "+":
                System.out.println((a + " " + operator + " " + b) + " = " + sum(a, b));
                return sum(a, b);
            case "-":
                System.out.println((a + " " + operator + " " + b) + " = " + diff(a, b));
                return diff(a, b);
            case "*":
                System.out.println((a + " " + operator + " " + b) + " = " + multiplication(a, b));
                return multiplication(a, b);
            case "/":
                System.out.println((a + " " + operator + " " + b) + " = " + div(a, b));
                return div(a, b);
        }
        return null;
    }

    public static String sum(Object num1, Object num2) {
        if((num1 instanceof Double) || (num2 instanceof Double)){
            return (Double)num1 + (Double)num2 + "";
        }
        return (Integer)num1 + (Integer)num2 + "";
    }

    public static String diff(Object num1, Object num2) {
        if((num1 instanceof Double) || (num2 instanceof Double))
        {
            return (Double)num1 - (Double)num2 + "";
        }
        return (Integer)num1 - (Integer)num2 + "";
    }

    public static String div(Object num1, Object num2) {
        if((num1 instanceof Double) || (num2 instanceof Double))
        {
            return (Double)num1 / (Double)num2 + "";
        }
        else{
            String str1 = Objects.toString (num1);
            String str2 = Objects.toString (num2);
            double n1 = Double.parseDouble(str1);
            double n2 = Double.parseDouble(str2);
            return n1 / n2 + "";
        }
    }

    public static String multiplication(Object num1, Object num2) {
        if((num1 instanceof Double) || (num2 instanceof Double))
        {
            return (Double)num1 * (Double)num2 + "";
        }
        return (Integer)num1 * (Integer)num2 + "";
    }
}

