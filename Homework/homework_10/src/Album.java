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
    public boolean isFull(int numberPage) {
        if(pages[numberPage].countAddPhotos() == pages[numberPage].photos.length) {
            return true;
        }
        else {
            return false;
        }
    }


    public void setPhoto(String namePhoto){
        if (this.numberPage < pages.length) {
            if(pages[numberPage] != null){
                if (numberPage == 0){
                    pages[numberPage] = new Page(countPhotoesOnPage, numberPage);
                }
                pages[numberPage].setPhoto(namePhoto);
            }
            if(pages[numberPage].countAddPhotos() == pages[numberPage].photos.length) {
                this.numberPage++;
            }
                pages[numberPage] = new Page(countPhotoesOnPage, numberPage);
                pages[numberPage].setPhoto(namePhoto);
            }
        }
    }
}
