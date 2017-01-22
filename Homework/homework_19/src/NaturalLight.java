/**
 * Created by Ravskiy Pavel on 19.01.2017.
 */
public abstract class NaturalLight implements SourceOfLight{

/*    String name;
    @Override
    public String getName(){
        return this.name;
    }*/
    @Override
    public void showName(String name) {
       // return "NaturalLight - " + name;
        System.out.println("NaturalLight - " + name);
    }
}
