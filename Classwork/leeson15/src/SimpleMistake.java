/**
 * Created by java on 23.12.2016.
 */
public class SimpleMistake {
    public static void mistake() {
        try {
            int d = 0;
            int a = 42 / d;
            int z = a + d;
            System.out.println(d);
        }
        catch (ArithmeticException y) {
            System.out.println("Деление на ноль");
        }
    }
    public static void mistake1() {
            try {
                String shortString = "123";
                char chr = shortString.charAt(10);
            } catch (Exception y) {
                System.out.println("\n" + y.toString());
            }
    }
}
