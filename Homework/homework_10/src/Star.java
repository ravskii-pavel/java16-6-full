/**
 * Created by Pavel on 15.12.2016.
 */
public class Star {
    String nameStar;
    int numberPlanet;
    int countPlanets;
    Planet []planets;

    public Star(String nameStar, int countPlanets) {
        this.nameStar = nameStar;
        this.planets = new Planet[countPlanets];
    }
    public boolean isFullStarSystem(){
        if(planets.length == countAddPlanets()){
            return true;
        }
        return false;
    }
    public int countAddPlanets(){
        int i = 0;
        while(planets[i] != null && i <= planets.length){
            i++;
            if (i == planets.length) {
                return i;
            }
        }
        return i;
    }
    public void addPlanet(String namePlanet, int countSatellites) {
        if(isFullStarSystem() == false){
            planets[countAddPlanets()] = new Planet(namePlanet, countSatellites);
        }
        else {
            System.out.println("В звездной системе заполнены все планеты");
        }
    }
    public void addPlanet(String namePlanet) {
        if(isFullStarSystem() == false){
            planets[countAddPlanets()] = new Planet(namePlanet);
        }
        else {
            System.out.println("В звездной системе заполнены все планеты");
        }
    }

}
