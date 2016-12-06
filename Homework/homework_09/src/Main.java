import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        /*System.out.println(Calc.sum("123", "22"));
        System.out.println(Calc.sum(12.33F, 12.4F));*/
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter operator:  ");
            String operator = scanner.next();

            System.out.print("Enter first operand:  ");
            String a = scanner.next();
            Object a1 = Object.toString(a);
            Object typeFirst = Calc.typeData(a);
            System.out.print("Enter second operand:  ");
            Object b = scanner.next();
            Object typeSecond = Calc.typeData(b);

            if (typeFirst != typeSecond){
                break;
            }
            System.out.println(typeFirst);
            System.out.println(typeSecond);
            /*switch (operator) {
                case "+":
                    System.out.print((a + " " + operator + " " + b) + " = " + Calc.sum(a, b));
                    break;
                case "-":
                    System.out.print((a + " " + operator + " " + b) + " = " + Calc.diff(a, b));
                    break;
                case "*":
                    System.out.print((a + " " + operator + " " + b) + " = " + Calc.multiplication(a, b));
                    break;
                case "/":
                    System.out.print((a + " " + operator + " " + b) + " = " + Calc.div(a, b));
                    break;
            }*/
            System.out.println("Would you like to continue? Enter y/n: ");
            String exitWord = scanner.next();
            System.out.println(exitWord);
            if (exitWord != null && exitWord.length() > 0 && !exitWord.equalsIgnoreCase("y")){
                break;
            }
        }

    }
}
