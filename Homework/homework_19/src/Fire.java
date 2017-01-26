/**
 * Created by Ravskiy Pavel on 19.01.2017.
 */
public class Fire extends NaturalLight {

    boolean isItStuffCanBurn, isFire;

    Fire (String name, boolean isTurnedOn, boolean isItStuffCanBurn, boolean isFire) {
        this.name = name;
        this.isTurnedOn = isTurnedOn;
        this.isItStuffCanBurn = isItStuffCanBurn;
        this.isFire = isFire;
    }

    @Override
    public void isItWorks() {
        if(this.isTurnedOn == true && this.isItStuffCanBurn == true && this.isFire == true){
            System.out.println(getName() + " is burning");
        }
        else{
            System.out.println(getName() + " is not burning");
        }
    }
}
