/**
 * Created by Ravskiy Pavel on 19.01.2017.
 */
public class Fire extends NaturalLight {

    boolean isTurnedOn, isItStuffCanBurn, isFire;

    String name;
    public Fire(boolean isDay, String sourceName, String action) {
        super(isDay, sourceName, action);
    }

    //@Override
    public void turnOn(boolean isTurnedOn) {
        if (isTurnedOn == true && isItStuffCanBurn == true && isFire == true){
            this.isTurnedOn = true;
        }
        else{
            this.isTurnedOn = false;
        }
    }

    @Override
    public void isItWorks() {

    }

    @Override
    public String getName() {
        return this.name;
    }
}
