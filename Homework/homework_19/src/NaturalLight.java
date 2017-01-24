/**
 * Created by Ravskiy Pavel on 19.01.2017.
 */
public abstract class NaturalLight implements SourceOfLight{

    boolean isDay;
    String sourceName, action;

   public NaturalLight(boolean isDay, String sourceName, String action) {
        this.isDay = isDay;
        this.sourceName = sourceName;
        this.action = action;
    }

    @Override
    public void showName() {
       System.out.println("NaturalLight - " + getName());
    }

    @Override
    public void turnOn(boolean isTurnedOn, int voltage) {

    }
}
