/**
 * Created by Ravskiy Pavel on 19.01.2017.
 */
public abstract class ArtificialLight implements SourceOfLight {

    String name;
    ArtificialLight(String name){
        this.name = name;
    }

   @Override
    public void showName(SourceOfLight sourceOfLight) {
       System.out.println("ArtificialLight - " + sourceOfLight.getName());
    }

}
