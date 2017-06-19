import java.util.*;
public class Main {
    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {

        float[] usd = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int grade[] = {3, 5, 2, 5, 5, 5, 5, 2, 3, 5, 3};
        int numbers[] = {0, 5, 2, 5, 5, 5, 5, 2, 3, 5, 3, 15, 15, 16, 25, 20, 405, 455};
        aLotOfStars("java");
        nameFromColumn("Juventus");
        summOfOddNum();
        sumIncrease(3, 1000);
        sumOfDepPerMonth(3, 1000);
        sumOfDep(60, 1000);
        envelope(6, 8, 5, 7);
        biggestNum(5.7F, 9.6F);
        oneEvenNum(87, 88);
        positiveNum(0, -8);
        conformityTable();
        convertUsdToUah(usd);
        cellsOfAmoeba();
        numberOfStudents(grade);
        evenNumbers(numbers);

    }
    /* 1) Дано слово. Добавить к нему в начале и конце столько звездочек, сколько букв в этом слове.*/
    /*-----------------------------------------------------------------------------------------*/
    public static String aLotOfStars(String word) {
        String resultWord = "";
        int i, j;
        for (j = 0; j < 2; j++) {
            for (i = 0; i < word.length(); i++) {
                resultWord = resultWord + '*';
            }
            i = 0;
            if (j == 0) {
                resultWord = resultWord + word;
            }
        }
        System.out.println("1) " + resultWord);
        return resultWord;
    }
    /*  2) Дано название футбольного клуба. Напечатать его на экране "столбиком".*/
    /*-----------------------------------------------------------------------------------------*/
    public static void nameFromColumn(String nameTeam) {
        int count = nameTeam.length();
        System.out.println("2) ");
        for (int k = 0; k < count; k++) {
            System.out.println(nameTeam.charAt(k));
        }
    }
    /* 3) Найти сумму положительных нечетных чисел, меньших 50.*/
    /*-----------------------------------------------------------------------------------------*/
    public static int summOfOddNum() {
        int result = 0;
        for (int k = 50; k > 0; k--) {
            if (k % 2 == 1) {
                result = result + k;
            }
        }
        System.out.println("3) Сумма положительных нечетных чисел, меньших 50: " + result);
        return result;
    }
    /* 4) Вася открыл счет в банке 1 марта, вложив 1000 грн. Через каждый месяц размер вклада увеличивается на 2% от
    имеющейся суммы. Определить:
     а) прирост суммы вклада за каждый месяц с 1-го марта до конца года;
     б) сумму вклада через: полгода, 2 года, 5 лет.*/
   /* -----------------------------------------------------------------------------------------
    а) общий прирост суммы вклада за каждый месяц с 1-го марта до конца года;*/
    public static float sumIncrease(int month, float startSum) {

        float finalSum = startSum;
        int term = 12 - month;
        for (int i = 1; i <= term; i++) {
            finalSum = finalSum + ((finalSum * 2) / 100);
        }
        System.out.println("4.a) Общий прирост суммы вклада до конца года: " + (finalSum - startSum));
        return (finalSum - startSum);
    }
    /* ---------------------------------------------------------------------------------------
    а) помесячный прирост суммы вклада за каждый месяц с 1-го марта до конца года;*/
    public static float[] sumOfDepPerMonth(int month, float startSum) {

        int term = 12 - month;
        float[] increaseSumPerMonth = new float[term];
        float finalSum = startSum;
        System.out.print("4.a) ");
        for (int i = 0; i < term; i++) {
            increaseSumPerMonth[i] = finalSum + ((finalSum * 2) / 100);
            finalSum = increaseSumPerMonth[i];
            System.out.println("Прирост суммы вклада за " + (i + 1) + " месяц: " + (finalSum - startSum));
        }
        return increaseSumPerMonth;
    }
    /*б) сумму вклада через: полгода, 2 года, 5 лет.*/
/* ------------------------------------------------------------------------------*/
    public static float[] sumOfDep(int countOfMonth, float startSum) {
        int i;
        float[] increaseSumPerMonth = new float[countOfMonth];
        float finalSum = startSum;
        for (i = 0; i < countOfMonth; i++) {
            increaseSumPerMonth[i] = finalSum + ((finalSum * 2) / 100);
            finalSum = increaseSumPerMonth[i];
        }
        System.out.println("4.б) Сумма вклада через полгода: " + increaseSumPerMonth[5]);
        System.out.println("Сумма вклада через 2 года: " + increaseSumPerMonth[23]);
        System.out.println("Сумма вклада через 5 лет: " + increaseSumPerMonth[59]);
        return increaseSumPerMonth;
    }
    /* 5) Определить, войдет ли в конверт с внутренними размерами a и b мм прямоугольная открытка размером с и d мм.
    Для размещения открытки в конверте необходим зазор в 1 мм с каждой стороны.*/
    /*------------------------------------------------------------------------------------*/
    public static boolean envelope(int envelopeA, int envelopeB, int cardC, int cardD) {
        if ((envelopeA > cardC) && (envelopeB > cardD)){
            System.out.println("5) Открытка с размерами: " + cardC + "x" + cardD + " мм" + " войдет в конверт: " + envelopeA
            + "x" + envelopeB + " мм");
            return true;
        }
        System.out.println("5) Открытка с размерами: " + cardC + "x" + cardD + " мм" + " не войдет в конверт: " + envelopeA
        + "x" + envelopeB + " мм");
        return false;
    }
    /* 6) Даны два различных вещественных числа. Определить наибольшее из них применив
    один неполный условный оператор.*/
    /*------------------------------------------------------------------------------------*/
    public static float biggestNum(float num1, float num2) {
        if (num1 < num2) {
            System.out.println("6) Число: " + num2 + " больше " + num1);
            return num2;
        }
        System.out.println("6) Число: " + num1 + " больше " + num2);
        return num1;
    }
    /* 7) Записать условие, которое является истинным, когда:
     a) только одно из чисел А и В четное;*/
    /*---------------------------------------------------------------------------------------*/
    public static boolean oneEvenNum(int a, int b) {
        if (((a % 2 == 1) && (b % 2 == 1)) || ((a % 2 == 0) && (b % 2 == 0))) {
            System.out.println("7.a) НЕ выполняется условие: только одно из чисел А и В четное!");
            return false;
        }
        System.out.println("7.a) Условие выполняется: только одно из чисел А и В четное!");
        return true;
    }
    /*б) хотя бы одно из чисел А и В положительно;*/
    /*---------------------------------------------------------------------------------------*/
    public static boolean positiveNum(int a, int b) {
        if (a > 0 || b > 0) {
            System.out.println("7.б) Условие выполняется: хотя бы одно из чисел А и В положительно!");
            return true;
        }
        System.out.println("7.б) Условие НЕ выполняется: хотя бы одно из чисел А и В положительно!");
        return false;
    }

    /* 8) Напечатать таблицу соответствия между весом в фунтах и весом в килограммах
    для значений 1, 2, ..., 10 фунтов (1 фунт = 453 г).*/
    /*-----------------------------------------------------------------------------------------*/
    public static void conformityTable() {
        float[] pound = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        float[] kilogramm = new float[pound.length];
        System.out.println("8) Таблица соответствия");
        System.out.println("POUNDS  " + " KILOGRAMS");
        for (int i = 0; i < pound.length; i++) {
            kilogramm[i] = (453 * pound[i]) / 1000;
            System.out.println(pound[i] + "       " + kilogramm[i]);
        }
    }
    /* 9) Напечатать таблицу перевода 1, 2, ... 20 долларов США в гривны по текущему курсу
     (значение курса вводится с клавиатуры).*/
    /*-----------------------------------------------------------------------------------------*/
    public static void convertUsdToUah(float[] usd) {
        System.out.println("9) Обмен валют (USD -> UAH): ");
        System.out.print("Введите курс доллара на сегодня: ");
        float exchangeRate = reader.nextFloat();
        float[] uah = new float[usd.length];
        System.out.println("USD  " + "   UAH");
        for (int i = 0; i < usd.length; i++) {
            uah[i] = exchangeRate * usd[i];
            System.out.println(usd[i] + "    " + uah[i]);
        }
    }
    /* 10) Одноклеточная амеба каждые 3 часа делится на 2 клетки.
    Определить, сколько клеток будет через 3, 6, 9, ..., 24 часа, если первоначально была одна амеба.*/
    /*-----------------------------------------------------------------------------------------*/
    public static int[] cellsOfAmoeba() {
        int cell = 1;
        int countOfHours = 3;
        int[] countOfCells = new int[24 / countOfHours];
        System.out.println("10) Определить, сколько клеток будет через 3, 6, 9, ..., 24 часа, если первоначально была одна амеба");
        System.out.println("HOURS  " + " CELLS");
        for (int i = 0; i < 24 / countOfHours; i++) {
            cell = cell * 2;
            countOfCells[i] = cell;
            System.out.println(countOfHours * (i + 1) + "       " + cell);
        }
        return countOfCells;
    }

    /* 11) В массиве записаны оценки по информатике 22 учеников класса. Определить количество учеников,
    оценка которых меньше средней оценки по классу, и вывести номера элементов массива,
    соответствующих таким ученикам.*/
    /*-----------------------------------------------------------------------------------------*/
    public static void numberOfStudents(int grade[]) {
        int countOfStudents = 0;
        float averageGrade = 0;
        System.out.println("11) Количество учеников, оценка которых меньше средней оценки и их № эл. массив:");
        for (int i = 0; i < grade.length; i++) {
            averageGrade = averageGrade + grade[i];
            if (i == (grade.length - 1)) {
                averageGrade = averageGrade / grade.length;
            }
        }
        for (int i = 0; i < grade.length; i++) {
            if (grade[i] < averageGrade) {
                countOfStudents++;
                System.out.println("Элемент массива:  " + i);
            }
        }
        System.out.println("Количество учеников:  " + countOfStudents);
    }

    /* 12) Дан массив целых чисел. Определить количество четных элементов и количество элементов,
    оканчивающихся на цифру 5*/
    /*-----------------------------------------------------------------------------------------*/
    public static void evenNumbers(int grade[]) {
        int countOfEvenNum = 0;
        int countOfEnd5Num = 0;

        System.out.println("12) Количество четных элементов и количество элементов, оканчивающихся на цифру 5: ");
        for (int i = 0; i < grade.length; i++) {

            System.out.print(grade[i] + ", ");
            if (grade[i] % 2 == 0) {
                countOfEvenNum++;
            }
            if (((grade[i]%5 == 0) && (((grade[i]/5)%2) != 0)) || (grade[i] == 5)) {
                countOfEnd5Num++;
            }
        }
        System.out.println("\nКоличество четных элементов: " + countOfEvenNum);
        System.out.println("Количество элементов оканчивающихся на цифру 5: " + countOfEnd5Num);
    }
}
