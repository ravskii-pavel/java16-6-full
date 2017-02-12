package autosalon;

/**
 * Created by java on 13.01.2017.
 */
public class Lanos extends  Car {

    public Lanos(double fuelConsumption, int maxSpeed, Configuration configuration) {
        super(fuelConsumption, maxSpeed, configuration);
    }

    @Override
    public double getPrie() {
        switch (getConfiguration()){
            case LUX:
                return 10_000;

            case EXCLUSIVE:
                return 15_000;

            default:
                return 5000;
        }

    }
}
