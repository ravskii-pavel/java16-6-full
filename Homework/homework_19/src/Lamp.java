/**
 * Created by Ravskiy Pavel on 19.01.2017.
 */
public class Lamp extends ArtificialLight {

   private static int count = 0;

   Lamp(String name){
       super(name);
       count++;
   }
    Lamp(){
        super();
    }

    public int getQuantity(){
        return count;
    }
}
