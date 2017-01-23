/**
 * Created by Ravskiy Pavel on 19.01.2017.
 */
public class Lamp extends ArtificialLight {

   private static int count = 0;

   Lamp(String name){
       super(name);
       count++;
   }

    public int getQuantity(){
        return count;
    }

    @Override
    public String getName(){
        return this.name;
    }


    @Override
    public void isItWorks() {

    }
}
