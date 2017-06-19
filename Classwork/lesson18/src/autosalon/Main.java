package autosalon;

import javax.annotation.processing.Completion;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Car[] cars = {new Lanos(10, 160, Configuration.BASIC),
                new Mercedes(15, 220, Configuration.LUX),
                new Opel(18, 220, Configuration.EXCLUSIVE),
                new Opel(18, 180, Configuration.BASIC),
                new Lanos(12, 170, Configuration.LUX),
                new Mercedes(18, 180, Configuration.BASIC)
        };
        Autosalon autosalon = new Autosalon(cars);
        System.out.println("Total cars price: " + autosalon.calculateCarsPrice());
        System.out.println(Arrays.toString(autosalon.sortByFuelConsumption()));

        System.out.println(Arrays.toString(autosalon.getCarsBySpeedRange(160, 170)));
    }
}
