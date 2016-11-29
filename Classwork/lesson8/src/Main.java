public class Main {


    public static void main(String[] args) {
        System.out.println("Hello World!");
        ekran();
        reverse();
        forfor();
        forfor1();
    }
    public static void ekran (){
        int i = 90;
        while (i>=0){
            System.out.println(i);
            i-=5;
        }
    }
    public static void reverse(){
        int num = 257;
        int result;
        do{
            result = num%10;
            System.out.print(result);
            num = num/10;
        }while (num>0);
    }

    public static void forfor(){

        String [] arr = {"ert", "hhh", "A"};
        for(String s1: arr) {
            System.out.println("Имя: " + s1);
        }
    }

    public static void forfor1(){

        String [] arr = {"ert", "hhh", "A"};
        for(String s1: arr) {
            System.out.println(s1 + " - " + s1.length());
        }
    }
}
