public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Country country1 = new Country("Ukraine", 10000);
        Country country2 = new Country("Ukraine", 10000);

        System.out.println(country1.equals(country2));
    }
}
