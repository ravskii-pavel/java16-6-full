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


    public void setNumberPhoto(int numberPhoto) {
        this.numberPhoto = numberPhoto;
    }

    public void setPhoto(String namePhoto, int numberPhoto){
        if (this.photoes != null) {
            this.photoes[numberPhoto] = new Photo(namePhoto);
          /*  numberPhoto++;
            setNumberPhoto(numberPhoto);*/

        }
        else{
            System.out.println("Нет места для фото");
        }
    }
}
