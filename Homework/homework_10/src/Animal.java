/**
 * Created by Pavel on 08.12.2016.
 */
public class Animal {

    String nameAnimal;
    int countLimbs;
    habitat nameHabitat;

/*  public Animal(String nameAnimal, int countLimbs, habitat nameHabitat) {
        this.nameAnimal = nameAnimal;
        this.countLimbs = countLimbs;
        this.nameHabitat = nameHabitat;
    }*/

    /*public Animal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }*/

    public void movement(){
        System.out.println("Передвигаться");
    }

    public enum habitat{
        SEA, LAND;
    }

}



