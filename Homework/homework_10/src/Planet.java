/**
 * Created by Pavel on 15.12.2016.
 */
public class Planet {

    String namePlanet;
    Satellite[] satellites;

    public Planet(String namePlanet, int countSatellites){
        this.namePlanet = namePlanet;
        this.satellites = new Satellite[countSatellites];
    }
    public Planet(String namePlanet){
        this.namePlanet = namePlanet;
    }

}
