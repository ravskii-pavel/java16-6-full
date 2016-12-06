/**
 * Created by java on 02.12.2016.
 */

public class Calc {

    public static Object typeData(Object a){

        if (a instanceof String){
            return "String";
        }
        else if (a instanceof Double){
            return "Double";
        }
        else if (a instanceof Integer){
            return "Integer";
        }
        else {
            return "Введите корректные данные";
        }
    }
    public static int sum(int num1, int num2) {

        int result = num1 + num2;
        return result;
    }

    public static float sum(float num1, float num2) {

        float result = num1 + num2;
        return result;
    }

    public static int sum(String num1, String num2) {

        int result = Integer.parseInt(num1) + Integer.parseInt(num2);
        return result;
    }

    public static int diff(int num1, int num2) {

        int result = num1 - num2;
        return result;
    }
    public static float diff(float num1, float num2) {

        float result = num1 - num2;
        return result;
    }
    public static int diff(String num1, String num2) {

        int result = Integer.parseInt(num1) + Integer.parseInt(num2);
        return result;
    }

    public static int div(String num1, String num2) {

        int result = Integer.parseInt(num1) / Integer.parseInt(num2);
        return result;
    }

    public static float div(float num1, float num2) {

        float result = num1 / num2;
        return result;
    }
    public static int div(int num1, int num2) {

        int result = num1 / num2;
        return result;
    }
    public static int multiplication(int num1, int num2) {

        int result = num1 * num2;
        return result;
    }
    public static float multiplication(float num1, float num2) {

        float result = num1 * num2;
        return result;
    }
    public static int multiplication(String num1, String num2) {

        int result = Integer.parseInt(num1) * Integer.parseInt(num2);
        return result;
    }

}

