public class Main {

    public static void main(String[] args) {

        /*Bar uglyCoyote = new Bar("uglyCoyote");
        Bar uglyCoyote1 = new Bar("uglyCoyote1");
        uglyCoyote.addDrinkInBar("Whiskey", 1250);
        uglyCoyote.addDrinkInBar("Whiskey", 1150);
        uglyCoyote.addDrinkInBar("Rom", 1259);
        uglyCoyote.addDrinkInBar("Tequila", 2000);
        uglyCoyote.addEmployee("Tom", 24, "waiter", uglyCoyote);
        uglyCoyote.addEmployee("Tom", 24, "waiter", uglyCoyote);
        uglyCoyote.addEmployee("John", 24, "waiter", uglyCoyote);
        uglyCoyote.addEmployee("John1", 24, "waiter", uglyCoyote);
        uglyCoyote.addEmployee("Alex", 30, "barman", uglyCoyote);*/

        Bar uglyCoyote = new Bar();
        uglyCoyote.addEmployee("Michal", 30, "barman", uglyCoyote);

        //System.out.println();


       /* boolean is = uglyCoyote.waiters[0].equals(uglyCoyote.waiters[1]);
        System.out.println("standart equals - " + is);
        boolean is1 = uglyCoyote.waiters[0].equals(uglyCoyote.waiters[1]);
        System.out.println("Overraide equals - " + is1);

        int hCode0 = uglyCoyote.waiters[0].hashCode();
        System.out.println(hCode0);

        int hCode1 = uglyCoyote.waiters[1].hashCode();
        System.out.println(hCode1);

        //System.out.println(hCode == hCode1);

        uglyCoyote.waiters[0].takeOrder("Whiskey", 2230);
        uglyCoyote.waiters[0].takeOrder("Whiskey", 1230);
        uglyCoyote.waiters[0].takeOrder("Whiskey", 100);
        uglyCoyote.waiters[0].takeOrder("Tequila", 1880);
        uglyCoyote.waiters[1].takeOrder("Tequila", 108);
        uglyCoyote.waiters[0].takeTips(654);
        uglyCoyote.waiters[0].takeTips(67);
        System.out.println(uglyCoyote.allTips);

        //uglyCoyote.delEmployee("John", 24, "waiter");

        uglyCoyote.barmen[0].compleateOrder(1);*/
        //uglyCoyote.shareAllTips();

        //System.out.println(uglyCoyote.shareAllTips());

    }
}
