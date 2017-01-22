/**
 * Created by Ravskiy Pavel on 19.01.2017.
 */
public class Fire extends NaturalLight {
    @Override
    public void turnOn() {

    }
    String name;

    Fire(String name){
        this.name = name;
    }
//    @Override
//    public void calculateLifeTime() {
//
//    }

    @Override
    public void isItWorks() {

    }

    @Override
    public String getName() {
        return this.name;
    }
}
