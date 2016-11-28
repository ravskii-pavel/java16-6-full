public class Main {

    public static void main(String[] args) {

        int x;
        int y;

        x = 1;
        y = -1;

        System.out.println("a) (x*x + y*y) <= 4 :  " + ((x*x + y*y) <= 4));
        x = 1;
        y = 2;
        System.out.println("б) (x >= 0) || (y*y != 4):  " + ((x >= 0) || (y*y != 4)));
        System.out.println("в)(x >= 0) && (y*y != 4):  " + ((x >= 0) && (y*y != 4)));
        x = 2;
        y = 1;
        System.out.println("г) (x * y != 0) && (y > x):  " + ((x * y != 0) && (y > x)));
        System.out.println("д) (x * y != 0) && (y < x):  " + ((x * y != 0) && (y < x)));
        System.out.println("е) (!(x * y < 0)) && (y > x):  " + (!(x * y < 0) && (y > x)));
        x = 1;
        y = 2;
        System.out.println("ж) (!(x * y < 0)) || (y > x):  " + (!(x * y < 0) || (y > x)));
    }
}
