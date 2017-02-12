package autosalon;

/**
 * Created by java on 13.01.2017.
 */
public class Opel extends  Car {

    public Opel(double fuelConsumption, int maxSpeed, Configuration configuration) {
        super(fuelConsumption, maxSpeed, configuration);
    }

    @Override
    public double getPrie() {
        switch (getConfiguration()){
            case LUX:
                return 11_000;
            
            case EXCLUSIVE:
                return 16_000;

            default:
                return 6000;
        }

    }
}
