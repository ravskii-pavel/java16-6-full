package autosalon;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Car[] cars = {
        new Lanos(160, 10, Configuration.BASIC),
        new Mercedes(220, 15, Configuration.LUX),
        new Opel(180, 18, Configuration.BASIC),
        new Opel(220,18, Configuration.EXCLUSIVE),
        new Lanos(170,12, Configuration.LUX),
        new Mercedes(180, 18, Configuration.BASIC)
        };
            // the same for(Car car : cars)
        for (Action car : cars){
            car.stop();
            car.beep();
            car.drive();
        }


        AutoSalon autoSalon = new AutoSalon(cars);

        System.out.println("Total price: " + autoSalon.calculateCarsPrice());
        System.out.println(Arrays.toString(autoSalon.sortByFuelConsumption()));
        System.out.println(Arrays.toString(autoSalon.getCarsBySpeedRange(0, 170)));
    }
}
