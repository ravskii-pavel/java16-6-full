/**
 * Created by Pavel on 09.12.2016.
 */
public class Page {

    int numberPhoto;
    int numberPage;
    Photo [] photos;

    Page(int countPhotoesOnPage, int numberPage) {
        this.numberPage = numberPage;
        this.photos = new Photo[countPhotoesOnPage];
    }

    public void addPhoto(Photo photo, int numberPhoto){
        photos[numberPhoto] = photo;
    }


    public void setNumberPhoto(int numberPhoto) {
        this.numberPhoto = numberPhoto;
    }

    public int countAddPhotos(){
        int i = 0;
        while (photos[i] != null && i <= photos.length){
            i++;
        }
        return i;
    }

    public void setPhoto(String namePhoto, int numberPhoto){
        if (this.photos != null) {
            this.photos[numberPhoto] = new Photo(namePhoto);
        }
        else{
            System.out.println("Нет места для фото");
        }
    }
}
