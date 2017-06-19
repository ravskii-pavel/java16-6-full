public class Main {

    public static void main(String[] args) {

        int number = 18;
        int unsignedNumber = (number < 0) ? (-number) : number;

        int countOfDozens = unsignedNumber / 10;
        int modNumber = unsignedNumber % 10;
        int sum = countOfDozens + modNumber;
        int multiplication = countOfDozens * modNumber;

        System.out.println("Количество десятков в числе " + number + ": " + countOfDozens);
        System.out.println("Количество единиц в числе " + number + ": " + modNumber);
        System.out.println("Сумма цифр числа " + number + ": " + sum);
        System.out.println("Произведение цифр числа " + number + ": " + multiplication);

    }
}
