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
            int a = scanner.nextInt();

            System.out.print("Enter second operand:  ");
            int b = scanner.nextInt();

            switch (operator) {
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
            }
            System.out.println("Would you like to continue? Enter y/n: ");
            String exitWord = " ";
            exitWord = scanner.next();
            System.out.println(exitWord);
            if (exitWord != null && exitWord.length() > 0 && !exitWord.equalsIgnoreCase("y")){
                break;
            }
        }

    }
}
