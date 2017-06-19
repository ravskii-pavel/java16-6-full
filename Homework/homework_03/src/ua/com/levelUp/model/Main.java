package ua.com.levelUp.model;

/**
 * Created by Pavel on 15.11.2016.
 */

public class Main {

    public static void main(String[] args) {
        Account object1 = new Account(1, 7);
        System.out.println("id = " + object1.id + " amount = " + object1.amount);

        Account object2 = new Account(543);
        System.out.println(object2.id);

        Account object3 = new Account();
        //object3.id = 777;
        //object3.amount = 9999;
        System.out.println(object3.id + " " + object3.amount);
        //---------------------------------------------------------
        //int result = super.getAmount(object1.amount);
        int result = object1.getAmount(object1.amount);
        System.out.println(result + " +++");

    }
}