import java.util.Random;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        calculator();
        Student stud = new Student (Lang.RU, "Harry", "Potter", 28, Faculty.RAVENCLAW);
        stud.toString();
        System.out.println(stud.toString());
        System.out.println("Random Faculty is: " + Faculty.getRandomFaculty());
        Student[]students = new Student[20];

        /*Для проверки 6 задания*/
        for (int i = 0; i < students.length; i++){
            students[i] = new Student (Lang.EN, "Harry", "Potter", 28, Faculty.values()[i%4]);
        }
        Student.choiceFaculty(students);
    }

/*  1)  Доделать консольный калькулятор, таким образом, чтобы была возможность применять базовые операции (+,-,/,*)
для разных типов входных данных, таких как:
    - Integer a, Integer b
    - Double a, Double b
    - String a, String b
    * Реализовать такую функциональность можно при помощи оператора instanceof. Например, у нас есть два целых числа
    * Integer a и Integer b, применив к ним оператор instanceof
      (а instanceof Integer) мы получим булевское выражение(true), и сможем подобрать необходимую перегрузку метода.
    **  Разбить функциональность на отдельные методы.*/

    public static void calculator() {
        boolean isExit = false;
        String result = null;
        Scanner scanner = new Scanner(System.in);

        while (!isExit) {
            System.out.print("Enter operator:  ");
            String operator = scanner.next();

            System.out.print("Enter first operand:  ");
            Object firstOperand = Calc.setType((result != null) ? result : scanner.next());
            if (null != result) {
                System.out.println(result);
            }
            System.out.print("Enter second operand:  ");
            Object secondOperand = Calc.setType(scanner.next());

            if ((firstOperand instanceof Double) || (secondOperand instanceof Double)) {
                firstOperand = Calc.setType(firstOperand);
                secondOperand = Calc.setType(secondOperand);
            } else {
                firstOperand = Calc.setTypeInt(firstOperand);
                secondOperand = Calc.setTypeInt(secondOperand);
            }

            result = Calc.getResult(operator, firstOperand, secondOperand);
            System.out.println("Would you like to continue? Enter y/n: ");
            String exitWord = scanner.next();

            if (exitWord != null && exitWord.length() > 0 && !exitWord.equalsIgnoreCase("y")) {
                break;
            }
        }
    }


}
