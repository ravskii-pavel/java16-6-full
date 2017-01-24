public class Main {

    public static void main(String[] args) {

        Lamp lamp = new Lamp();
        Flashlight flashlight = new Flashlight("BLACK DIAMOND");
        TableLamp tableLamp = new TableLamp("Table Lamp");
        //Fire fire = new Fire("Big Fire");

        flashlight.showName();
        tableLamp.showName();
        flashlight.turnOn(true, 20);
        tableLamp.turnOn(false, 16);
        flashlight.isItWorks();
        tableLamp.isItWorks();
        //fire.showName(fire);
        System.out.println("Количество источников света - " + lamp.getQuantity());

    }

}
