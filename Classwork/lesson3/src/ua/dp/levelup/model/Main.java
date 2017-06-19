package ua.dp.levelup.model;

/**
 * Created by java on 11.11.2016.
 */
public class Main
{
    static String lessonNumber = "lesson3";

    public static void main (String []args) {


        Square s1 = new Square();

        System.out.println(s1.getPerimeter());

        Square s2 = new Square(4);

        System.out.println(s2.getPerimeter());

        Square s3 = new Square("black", 4);

        System.out.println(s3.getPerimeter());


    }
}
