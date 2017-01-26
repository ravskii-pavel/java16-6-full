public class Main {

    public static void main(String[] args) {

        Lamp lamp = new Lamp("Lamp");
        Flashlight flashlight = new Flashlight("BLACK DIAMOND");
        TableLamp tableLamp = new TableLamp("Table Lamp");
        Sun sun = new Sun("Sun");
        sun.turnOn(true);
        sun.isDay();
        //sun.isItWorks();
        lamp.getQuantity();
        Fire fire = new Fire("Fire", true,true,true);
        fire.turnOn(false);
        fire.isItWorks();
        fire.showName();
        flashlight.turnOn(false, 17);
        flashlight.isItWorks();

    }

}
