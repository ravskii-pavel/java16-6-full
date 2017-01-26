/**
 * Created by Ravskiy Pavel on 19.01.2017.
 */
public class Lamp extends ArtificialLight {

   protected static int count = 0;

   Lamp(String name){
       super(name);
   }

    protected void getQuantity(){
        System.out.println("Количество источников искусственного света " + getName() + " - " + count);
    }
}
