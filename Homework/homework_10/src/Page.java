/**
 * Created by Pavel on 09.12.2016.
 */
public class Page {

    int numberPhoto = 0;
    int countOfPhotoes;
    int countPhotoesOnPage;
    int countAdds = 0;
    Photo [] photoes = new Photo[countPhotoesOnPage];

    Page(int countPhotoesOnPage) {
        this.countPhotoesOnPage = countPhotoesOnPage;
        this.photoes = new Photo[countPhotoesOnPage];
    }

    public void addPhoto(String namePhoto, int numberPage, int countOfPhotoesonPage){

        if (photoes[numberPhoto] == null && numberPhoto < photoes.length){
            photoes[numberPhoto]= new Photo (numberPhoto, "New photo");
        }
    }
}
