/**
 * Created by Ravskiy Pavel on 19.01.2017.
 */
public class Sun extends NaturalLight {

    public Sun(String name) {
        super(name);
    }

    public void isDay() {
        if (turnOn(this.isTurnedOn)){
            System.out.println("Day - " + getName() + " " + "is shining");
        } else {
            System.out.println("Night - " + getName() + " " + "is not shining");
        }
    }

    @Override
    public void isItWorks() {
        System.out.println(getName() + " works always");
    }
}
