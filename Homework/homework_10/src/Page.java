/**
 * Created by Pavel on 09.12.2016.
 */
public class Page {

    int numberPage;
    Photo [] photos;

    Page(int countPhotoesOnPage, int numberPage) {
        this.numberPage = numberPage;
        this.photos = new Photo[countPhotoesOnPage];
    }

    public int countAddPhotos(){
        int i = 0;
        while (photos[i] != null && i <= photos.length){
            i++;
            if (i == photos.length) {
                return i;
            }
        }
        return i;
    }
    public boolean isFullPage(Page page){
        if(page.countAddPhotos() == page.photos.length){
            return true;
        }
        return false;
    }

    public void setPhoto(String namePhoto){
        int numberPhoto = countAddPhotos();
        if (this.photos != null) {
            this.photos[numberPhoto] = new Photo(namePhoto);
        }
        else {
            System.out.println("ет места на сранице");
        }
    }
}
