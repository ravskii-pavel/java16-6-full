/**
 * Created by Ravskiy Pavel on 19.01.2017.
 */
public class Sun extends NaturalLight {
    boolean isTurnedOn = true;
    public Sun(boolean isDay, String sourceName, String action) {
        super(isDay, "Sun", isDay ? "is shining" : "is not shining");
    }


    /*@Override
    public void calculateLifeTime() {

    }*/

    @Override
    public void turnOn(boolean isTurnedOn) {
        if (super.isDay == true){
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
        return null;
    }
}
