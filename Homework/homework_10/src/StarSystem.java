/**
 * Created by Pavel on 15.12.2016.
 */
public class StarSystem {
    String nameStarSystem;
    Star star;

    public StarSystem(String nameStarSystem, String nameStar, int countPlanets){
        this.nameStarSystem = nameStarSystem;
        this.star = new Star(nameStar, countPlanets);
    }
}
