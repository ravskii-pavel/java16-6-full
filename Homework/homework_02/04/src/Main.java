public class Main {

    public static void main(String[] args) {

        int number = -95;
        int unsignedNumber = (number < 0) ? (-number) : number;
        int sign = (number < 0) ? -1 : 1;

        int countOfDozens = unsignedNumber / 10;
        int modNumber = unsignedNumber % 10;
        int result = sign * (modNumber * 10 + countOfDozens);

        System.out.println("Перестановка числа " + number + ": " + result);

    }
}
