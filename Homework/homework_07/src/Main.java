public class Main {

    public static void main(String[] args) {

        float[] usd = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int grade[] = {3, 5, 2, 5, 5, 5, 5, 2, 3, 5, 3};
        int numbers[] = {0, 5, 2, 5, 5, 5, 5, 2, 3, 5, 3, 15, 15, 16, 25, 20, 405, 455};
        daysOfMonth(2, args);
        playingCards(1, 8);
        dayOfWeek(364);
        notOnlyMonday(365);
        convertNumToString(7);
        reverseString("abc");
        validityOString("ravskii.pavel@gmail.com");

    }

    /* 1) Составить программу, которая в зависимости от порядкового номера месяца (1, 2, ..., 12) выводит
    на экран количество дней в этом месяце. Рассмотреть два случая:
        1) год не является високосным;
        2) год может быть високосным (информация об этом вводится в аргументы при запуске программы).*/
    /*-----------------------------------------------------------------------------------------*/
    public static void daysOfMonth(int month, String[] args) {
        System.out.println("1) Количество дней в указанном месяце высокосного / невысокосного года");
        int year = Integer.valueOf(args[0]);
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("В " + month + "месяце года - 31 день");
                break;
            case 2:
                if (year % 4 == 0) {
                    System.out.println("Февраль высокосного " + year + " года: 29 дней");
                } else {
                    System.out.println("Февраль невысокосного " + year + " года: 28 дней");
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("В " + month + " месяце года - 30 дней");
                break;
            default:
                System.out.println("неверные данные");
                break;
        }
    }

    /*2) Мастям игральных карт условно присвоены следующие порядковые номера: масти "пики" — 1, масти "трефы" — 2,
    масти "бубны" — 3, масти "червы" — 4, а достоинству карт: "валету" — 11, "даме" — 12, "королю" — 13,
    "тузу" — 14 (порядковые номера карт остальных достоинств соответствуют их названиям: "шестерка",
    "девятка" и т. п.). По заданным номеру масти m (1 <= m <=  4) и номеру достоинства карты k (6 <= k <= 14)
    определить полное название (масть и достоинство) соответствующей карты в виде "Дама пик", "Шестерка бубен" и т. п.*/
    public static void playingCards(int suitCard, int valueCard) {
        System.out.println("2) Игральные карты: ");
        String fullNameOfCard = "";
        switch (valueCard) {
            case 6:
                fullNameOfCard = fullNameOfCard + "Шестерка ";
                break;
            case 7:
                fullNameOfCard = fullNameOfCard + "Семерка ";
                break;
            case 8:
                fullNameOfCard = fullNameOfCard + "Восьмерка ";
                break;
            case 9:
                fullNameOfCard = fullNameOfCard + "Девятка ";
                break;
            case 10:
                fullNameOfCard = fullNameOfCard + "Десятка ";
                break;
            case 11:
                fullNameOfCard = fullNameOfCard + "Валет ";
                break;
            case 12:
                fullNameOfCard = fullNameOfCard + "Дама ";
                break;
            case 13:
                fullNameOfCard = fullNameOfCard + "Король ";
                break;
            case 14:
                fullNameOfCard = fullNameOfCard + "Туз ";
                break;
            default:
                System.out.println("Нет такой карты ");
                break;
        }
        switch (suitCard) {
            case 1:
                fullNameOfCard = fullNameOfCard + "пик";
                break;
            case 2:
                fullNameOfCard = fullNameOfCard + "треф";
                break;
            case 3:
                fullNameOfCard = fullNameOfCard + "бубен";
                break;
            case 4:
                fullNameOfCard = fullNameOfCard + "червей";
                break;
            default:
                System.out.println("Нет такой масти");
                break;
        }
        System.out.println(fullNameOfCard);
    }

    /* 3) Дано целое число k (1 <= k <= 365). Определить, каким днем недели (понедельником, вторником, ..., субботой
    или воскресеньем) является k-й день невисокосного года, в котором 1 января:
    а) понедельник;
    б) i-й день недели (если 1 января — понедельник, то d=1 , если вторник — d=2, ..., если воскресенье —  d= 7).*/
    public static void dayOfWeek(int numOfDay) {
        String nameOfDay = "";

        switch (numOfDay % 7) {
            case 1:
                nameOfDay = "Понедельник";
                System.out.println(nameOfDay);
                break;
            case 2:
                nameOfDay = "Вторник";
                System.out.println(nameOfDay);
                break;
            case 3:
                nameOfDay = "Среда";
                System.out.println(nameOfDay);
                break;
            case 4:
                nameOfDay = "Четверг";
                System.out.println(nameOfDay);
                break;
            case 5:
                nameOfDay = "Пятница";
                System.out.println(nameOfDay);
                break;
            case 6:
                nameOfDay = "Суббота";
                System.out.println(nameOfDay);
                break;
            case 0:
                nameOfDay = "Воскресенье";
                System.out.println(nameOfDay);
                break;
            default:
                System.out.println("Нет такого дня");
                break;
        }
    }

    /*б) i-й день недели (если 1 января — понедельник, то d=1 , если вторник — d=2, ..., если воскресенье —  d= 7).*/
    public static void notOnlyMonday(int numOfDay) {
        String nameOfDay = "";
        String firstDay = "Суббота";

        switch (firstDay) {
            case "Понедельник":
                dayOfWeek(numOfDay);
                break;
            case "Вторник":
                dayOfWeek(numOfDay + 1);
                break;
            case "Среда":
                dayOfWeek(numOfDay + 2);
                break;
            case "Четверг":
                dayOfWeek(numOfDay + 3);
                break;
            case "Пятница":
                dayOfWeek(numOfDay + 4);
                break;
            case "Суббота":
                dayOfWeek(numOfDay + 5);
                break;
            case "Воскресенье":
                dayOfWeek(numOfDay + 6);
                break;
            default:
                System.out.println("Нет такого дня");
                break;
        }
    }
    /* 4) Напишите программу для перевода чисел от 1 до 10 в строковое значение. Например,
    для числа 1 результатом будет строка “one”.*/
    public static void convertNumToString(int numOfDay) {
        String nameOfNum = String.valueOf(numOfDay);

        switch (numOfDay) {
            case 1:
                nameOfNum = "one";
                System.out.println(nameOfNum);
                break;
            case 2:
                nameOfNum = "two";
                System.out.println(nameOfNum);
                break;
            case 3:
                nameOfNum = "three";
                System.out.println(nameOfNum);
                break;
            case 4:
                nameOfNum = "four";
                System.out.println(nameOfNum);
                break;
            case 5:
                nameOfNum = "five";
                System.out.println(nameOfNum);
                break;
            case 6:
                nameOfNum = "six";
                System.out.println(nameOfNum);
                break;
            case 7:
                nameOfNum = "seven";
                System.out.println(nameOfNum);
                break;
            case 8:
                nameOfNum = "eight";
                System.out.println(nameOfNum);
                break;
            case 9:
                nameOfNum = "nine";
                System.out.println(nameOfNum);
                break;
            case 10:
                nameOfNum = "ten";
                System.out.println(nameOfNum);
                break;
            default:
                System.out.println("Неверные данные");
                break;
        }
    }
    /* 5) Дана строка. Написать программу, которая возвращает строку, написанную в обратном порядке. */
    public static void reverseString(String name) {
        String reverseName1 = new StringBuffer(name).reverse().toString();
        String reverseName2;
        int i,j;
        char[] arrName = name.toCharArray();
        int count = arrName.length;
        char[] arrRevers = new char[arrName.length];
        for(i = count-1, j = 0; i >= 0 && j<=arrName.length-1; i--, j++){
            arrRevers[j] = arrName[i];
        }
        System.out.println(arrName);
        reverseName2 = new String(arrRevers);
        System.out.print("5) Строка: ");
        System.out.println(arrName);
        System.out.print("Строка в обратном порядке: ");
        System.out.println(arrRevers);
    }

    /* 6) Дан email в виде строки. Написать программу для проверки email на валидность. email должен соответствовать
    условию (пример - emailaddr@domain.zone)
    1)	emailaddr > 4 символов
    2)	1 < domain < 10
    3)	2 <= zone < 5
    При любом несовпадении с условием выводим в консоль сообщение с указанием на конкретную ошибку.*/
    public static void validityOString(String email) {

        System.out.println("6) Проверка email адреса: ");
        String emailaddr, domain, zone;
        emailaddr = email.substring(0, email.indexOf('@'));
        domain = email.substring(emailaddr.length()+1, email.indexOf('.', emailaddr.length()+1));
        zone = email.substring((emailaddr.length()+1)+(domain.length()+1), email.length());

        if(emailaddr.length() <= 4){
            System.out.println("Email адрес должен быть больше 4 символов: " + emailaddr);
        }
        if((domain.length() <= 1) || (domain.length() >=10)){
            System.out.println("Название домена дожно быть другой длины: от 1 до 10 символов: " + domain);
        }
        if(zone.length() < 2 || zone.length() >= 5){
            System.out.println("Доменная зона должна быть другой длины: от 2 до 5 символов: " + zone);
        }
        else {
            System.out.println("email адрес прошел валидность ");
            System.out.println("Название адреса: " + emailaddr);
            System.out.println("Название домена: " + domain);
            System.out.println("Название доменной зоны: " + zone);
        }
    }
}