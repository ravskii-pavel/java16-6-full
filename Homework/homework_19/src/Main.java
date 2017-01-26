public class Main {

    public static void main(String[] args) {

        Lamp lamp = new Lamp("Lamp");
        Flashlight flashlight = new Flashlight("BLACK DIAMOND");
        TableLamp tableLamp = new TableLamp("Table Lamp");
        Sun sun = new Sun("Sun");
        sun.turnOn(false);
        sun.isDay();

        Fire fire = new Fire("Fire", true,true,true);
        fire.turnOn(true);
        fire.isItWorks();
        fire.showName();
        flashlight.turnOn(false, 17);
        flashlight.isItWorks();
        lamp.getQuantity();
    }
}
