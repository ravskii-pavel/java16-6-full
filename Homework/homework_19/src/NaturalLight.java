/**
 * Created by Ravskiy Pavel on 19.01.2017.
 */
public abstract class NaturalLight implements SourceOfLight{
    boolean isTurnedOn;
    String name;

   public NaturalLight(String name) {
       this.name = name;
    }
    NaturalLight() {}

    @Override
    public void showName() {
       System.out.println("NaturalLight - " + getName());
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public boolean turnOn(boolean isTurnedOn) {
        return this.isTurnedOn = isTurnedOn;
    }
}
