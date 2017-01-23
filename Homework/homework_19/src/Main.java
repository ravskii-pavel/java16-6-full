public class Main {

    public static void main(String[] args) {

        Lamp lamp = new Lamp("NITECORE");
        Flashlight flashlight = new Flashlight("BLACK DIAMOND");
        TableLamp tableLamp = new TableLamp("Table Lamp");
        //Fire fire = new Fire("Big Fire");

        lamp.showName(lamp);
        flashlight.showName(flashlight);
        tableLamp.showName(tableLamp);
        //fire.showName(fire);
        System.out.println(lamp.getQuantity());
    }

}
