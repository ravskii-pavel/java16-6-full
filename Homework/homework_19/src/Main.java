public class Main {

    public static void main(String[] args) {

        Lamp lamp = new Lamp("NITECORE");
        Flashlight flashlight = new Flashlight("BLACK DIAMOND");
        Fire fire = new Fire("Big Fire");

        print(lamp);
        print(flashlight);
        print(fire);




        //first.showName(first.getName());
    }
    public static void print(SourceOfLight sourceOfLight){

        sourceOfLight.showName(sourceOfLight.getName());
    }
}
