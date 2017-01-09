public class Main {

    public static void main(String... args) {

        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
        System.out.println("Hello World!");
        stars();
        workString();
    }

    public static void nameOfDay(int day) {
        String dayString;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thirsday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                dayString = null;
                break;
        }
    }

    public static void nameOfCards(int num) {
        String cardName;
        switch (num) {
            case 1:
                System.out.println("Пики");
                break;
            case 2:
                System.out.println("Трефы");
                break;
            case 3:
                System.out.println("Бубны");
                break;
            case 4:
                System.out.println("Червы");
                break;
            default:
                cardName = null;
        }
    }

    public static void stars() {

        for (int i = 0; i < 6; i++) {
            System.out.print("*");
            if (i!=0 || i!=5){
                for (int j = 0; j < 5; j++) {
                    if(j == 0 || j == 4){
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
                System.out.print("\n");
            }
        }
    }

    public static void workString(){
        String email1 = new String("9ravskii.pavel@gmail.com").intern(); // добавляет в пул строк
        String email2 = new String("ravskii.pavel@gmail.com"); //добавляется в hipp
        /*int countOfChar = email.length();
        char[] arr = email.toCharArray();
        System.out.println(email.substring(0, email.indexOf("@")));

        String a = new String("A");
        String a1 = "A";*/

        System.out.println(email1 == email2);
        System.out.println(email1.equals(email2));

        System.out.println(email1.compareTo(email2));

    }
}
