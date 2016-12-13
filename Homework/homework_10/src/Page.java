/**
 * Created by Pavel on 09.12.2016.
 */
public class Page {

    int numberPhoto;
    int numberPage;
    Photo [] photoes;

    Page(int countPhotoesOnPage, int numberPage) {
        this.numberPage = numberPage;
        this.photoes = new Photo[countPhotoesOnPage];
    }

    public void addPhoto(Photo photo, int numberPhoto){
        photoes[numberPhoto] = photo;
    }
    public void setPhoto(String namePhoto){
        if (this.photoes != null) {
            this.photoes[numberPhoto] = Photo(namePhoto) ;
            numberPage++;
        }
        else{
            System.out.println("Нет места для фото");
        }
    }

}
