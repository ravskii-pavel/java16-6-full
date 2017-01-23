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
/*    NaturalLight(String sourceName){
        this.sourceName = sourceName;
    }*/

    @Override
    public void showName(SourceOfLight sourceOfLight) {
       System.out.println("NaturalLight - " + sourceOfLight.getName());
    }

}
