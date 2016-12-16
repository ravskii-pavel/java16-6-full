/**
 * Created by Pavel on 09.12.2016.
 */
public class Album {
    int countPhotoesOnPage;
    int countPages;
    int numberPage;
    Page []pages;

    Album (int countPages, int countPhotoesOnPage){
        this.countPages = countPages;
        this.countPhotoesOnPage = countPhotoesOnPage;
        this.pages = new Page[countPages];
    }

    public boolean isFullAlbum(Object []obj) {
        Page[] page = (Page[])obj;
        if (page.length == this.numberPage+1 && page[this.numberPage].countAddPhotos() == page[this.numberPage].photos.length){
            return true;
        }
        return false;
    }
    public void changeNamePhoto(int numberPage, int numberPhoto, String namePhoto){
        if(pages.length <= numberPage || this.countPhotoesOnPage <= numberPhoto){
            System.out.println("№ страницы или № фотографии - не существует");
        }
        else {
            pages[numberPage].photos[numberPhoto].photoName = namePhoto;
        }
    }
    public void countPhotoOnDisplay(){
        int numberPage = 0;
        int countAllPhoto = 0;
        while (pages.length > numberPage && null != pages[numberPage]){
            countAllPhoto = countAllPhoto + pages[numberPage].countAddPhotos();
            numberPage++;
        }
        System.out.println("Количество добавленных фотографий в альбоме: " + countAllPhoto);
    }

    public void addPhoto(String namePhoto) {
        if (this.countPhotoesOnPage != 0 && isFullAlbum(pages) != true) {
            if (pages[this.numberPage] != null) {
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
    }
}
