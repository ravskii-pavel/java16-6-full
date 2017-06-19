/**
 * Created by Ravskiy Pavel on 19.01.2017.
 */
public abstract class ArtificialLight implements SourceOfLight {
    boolean isTurnedOn = true;
    String name;
    int voltage;
    ArtificialLight(String name){
        this.name = name;
    }
    ArtificialLight(){}

    @Override
    public void showName() {
       System.out.println("ArtificialLight - " + getName());
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean turnOn(boolean isTurnedOn) {return isTurnedOn;}

    public void turnOn(boolean isTurnedOn, int voltage) {
        this.isTurnedOn = isTurnedOn;
        this.voltage = voltage;
        System.out.println(this.isTurnedOn ? getName() + " - включен": getName() + " - выключен");
    }

    @Override
    public void isItWorks() {
        if ((this.isTurnedOn == true || this.isTurnedOn == false) && this.voltage <= 20){
            if(this.voltage >= 10){
                System.out.println(getName() + " - исправен");
            }
            else {
                System.out.println(getName() + " - исправен, " + this.voltage + "В - недостаточное напряжение");
            }
        }
        else {
            System.out.println(getName() + " - неисправен");
        }
    }
}
