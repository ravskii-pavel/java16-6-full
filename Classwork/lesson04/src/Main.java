public class Main {

    public static void main(String[] args) {

        StaticTest staticTest1 = new StaticTest();
        StaticTest staticTest2 = new StaticTest();

        staticTest1.staticVar = 100;

        staticTest2.nonStaticVar = 200;

        System.out.println(staticTest1.staticVar);
        System.out.println(staticTest2.staticVar);
        System.out.println(staticTest1.nonStaticVar);
        System.out.println(staticTest2.nonStaticVar);


    }
}
