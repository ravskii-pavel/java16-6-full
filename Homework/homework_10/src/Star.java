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
    public void isFullStarSystem(){

    }


  /*  public void addPlanet(String namePlanet, int countSatellites){
        if (this.countPlanets != 0 && isFullStarSystem() != true) {
            if (Planet[this.numberPlanet] != null) {
                if(pages[this.numberPage].isFullPage(pages[this.numberPage])) {
                    this.numberPage++;
                    pages[this.numberPage] = new Page(countPhotoesOnPage, this.numberPage);
                    pages[this.numberPage].addPhoto(namePhoto);
                }
                else {
                    pages[this.numberPage].addPhoto(namePhoto);
                }
            } else {
                pages[this.numberPage] = new Page(countPhotoesOnPage, this.numberPage);
                pages[this.numberPage].addPhoto(namePhoto);
            }
        }
        else{
            System.out.println("Альбом полностью заполнен - нет возможности добавить 1 фото с названием: " + namePhoto);
        }

    }*/
}
