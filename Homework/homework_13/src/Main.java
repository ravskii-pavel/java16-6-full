public class Main {

    public static void main(String[] args) {

        Bar uglyCoyote = new Bar();
        uglyCoyote.addDrinkInBar("Whiskey", 1250);
        uglyCoyote.addDrinkInBar("Whiskey", 1150);
        uglyCoyote.addDrinkInBar("Rom", 1259);
        uglyCoyote.addDrinkInBar("Tequila", 2000);
        uglyCoyote.addEmployee("Tom", 24, "waiter", uglyCoyote);
        uglyCoyote.addEmployee("Tom", 24, "waiter", uglyCoyote);
        uglyCoyote.addEmployee("John", 24, "waiter", uglyCoyote);
        uglyCoyote.addEmployee("John1", 24, "waiter", uglyCoyote);
        uglyCoyote.addEmployee("Alex", 30, "barman", uglyCoyote);
        uglyCoyote.addEmployee("Michal", 30, "barman", uglyCoyote);


        boolean is = uglyCoyote.waiters[0].equals(uglyCoyote.waiters[1]);
        System.out.println("standart equals - " + is);

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

        uglyCoyote.barmen[0].compleateOrder(1);
        uglyCoyote.shareAllTips();



        System.out.println(uglyCoyote.waiters[0].tipsInDay);


    }

}
