/**
 * Created by Pavel on 09.12.2016.
 */
public class Photo{

    int numberOfPage;
    String photoName;

    Photo(int numberOfPage, String photoName) {
        this.numberOfPage = numberOfPage;
        this.photoName = photoName + " - Фото на " + numberOfPage + " странице";
    }

}
