/**
 * Created by Ravskiy Pavel on 19.01.2017.
 */
public abstract class ArtificialLight implements SourceOfLight {

   /* String nameSourceOfLight;
    ArtificialLight(String nameSourceOfLight){
        this.nameSourceOfLight = nameSourceOfLight;
    }*/
    //String name;
    //String name;
/*    @Override
    public String getName(){
        return this.name;
    }*/

   @Override
    public void showName(String name) {
       System.out.println("ArtificialLight - " + name);
    }

  /*public void printName(SourceOfLight sourceOfLight) {
        System.out.println(sourceOfLight.showName( ));
    }*/

    /*@Override
    public void turnOn() {

    }

    @Override
    public void isItWorks() {

    }
    @Override
    public String showName(SourceOfLight sourceOfLight) {
        System.out.println();

    }*/
}
