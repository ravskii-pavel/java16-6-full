/**
 * Created by Pavel on 09.12.2016.
 */
public class Album {
    int numberPhoto;
    int countPhotoesOnPage;
    int numberPage;
    Page []pages = new Page[10];

    Album (int countPhotoesOnPage){
        this.countPhotoesOnPage = countPhotoesOnPage;
        this.numberPage = 0;
    }

    public void setPhoto(String namePhoto){
        if (numberPage < pages.length) {
            if(pages[numberPage] != null && pages[numberPage].countAddPhotos() != pages[numberPage].photos.length){
                pages[numberPage].setPhoto(namePhoto, numberPhoto);
            }
            else {
                pages[numberPage] = new Page(countPhotoesOnPage, numberPage);
                pages[numberPage].setPhoto(namePhoto, numberPhoto);
            }
            if(pages[numberPage].countAddPhotos() == pages[numberPage].photos.length){
                this.numberPage++;
            }
        }
    }
}
