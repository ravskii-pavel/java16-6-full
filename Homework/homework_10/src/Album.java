/**
 * Created by Pavel on 09.12.2016.
 */
public class Album {
    int countPhotoesOnPage;
    int numberPage;
    Page []pages = new Page[2];

    Album (int countPhotoesOnPage){
        this.countPhotoesOnPage = countPhotoesOnPage;
    }

    public boolean isFullAlbum(Object []obj) {
        Page[] page = (Page[])obj;
        if (page.length == this.numberPage+1 && page[this.numberPage].countAddPhotos() == page[this.numberPage].photos.length){
            return true;
        }
        return false;
    }


    public void setPhoto(String namePhoto) {
        if (isFullAlbum(pages) != true) {
            if (pages[this.numberPage] != null) {
                if(pages[this.numberPage].isFullPage(pages[this.numberPage])) {
                    this.numberPage++;
                    pages[this.numberPage] = new Page(countPhotoesOnPage, this.numberPage);
                    pages[this.numberPage].setPhoto(namePhoto);
                }
                else {
                    pages[this.numberPage].setPhoto(namePhoto);
                }
            } else {
                pages[this.numberPage] = new Page(countPhotoesOnPage, this.numberPage);
                pages[this.numberPage].setPhoto(namePhoto);
            }
        }
        else{
            System.out.println("Альбом полностью заполнен - нет возможности добавить еще 1 фото с названием: " + namePhoto);
        }
    }
}
