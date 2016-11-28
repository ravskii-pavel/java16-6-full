public class Main {

    public static void main(String[] args) {

        boolean X = false;
        boolean Y = false;
        boolean Z = true;


        System.out.println("a) X || Y && !Z:  " + (X || Y && !Z));
        System.out.println("б) !X && !Y:  " + (!X && !Y));
        System.out.println("в) !(X && Z) || Y:  " + (!(X && Z) || Y));
        System.out.println("г) X && !Y || Z:  " + (X && !Y || Z));
        System.out.println("д) X && (!Y || Z):  " + (X && (!Y || Z)));
        System.out.println("е) X || (!(Y || Z)):  " + (X || !(Y || Z)));

    }
}
