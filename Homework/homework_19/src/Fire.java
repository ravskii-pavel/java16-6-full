/**
 * Created by Ravskiy Pavel on 19.01.2017.
 */
public class Fire extends NaturalLight {
    String name;

    public Fire(boolean isDay, String sourceName, String action) {
        super(isDay, sourceName, action);
    }
  /*  Fire(String name){
        this.name = name;
    }*/


    //    @Override
//    public void calculateLifeTime() {
//
//    }
    @Override
    public void turnOn() {

    }

    @Override
    public void isItWorks() {

    }

    @Override
    public String getName() {
        return this.name;
    }
}
