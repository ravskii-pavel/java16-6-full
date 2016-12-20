/**
 * Created by Pavel on 15.12.2016.
 */
public class StarSystem {
    String nameStarSystem;
    Star star;

    public StarSystem(String nameStarSystem, String nameStar, int countPlanets){
        this.nameStarSystem = nameStarSystem;
        this.star = new Star (nameStar, countPlanets);
    }

    public void addPlanet(String namePlanet, int countSatellites) {
        if(star.isFullStarSystem() != true){
            star.addPlanet(namePlanet, countSatellites);
        }
        else {
            System.out.println(this.nameStarSystem + " - заполнена");
        }
    }
    public void addPlanet(String namePlanet) {
        if(star.isFullStarSystem() != true){
            star.addPlanet(namePlanet);
        }
        else {
            System.out.println(this.nameStarSystem + " - заполнена");
        }
    }
}
