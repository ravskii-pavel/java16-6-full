/**
 * Created by Pavel on 09.12.2016.
 */
public class Album {
    int countPhotosOnPage;
    int countPages;
    int numberPage;
    Page []pages;

    Album (int countPages, int countPhotosOnPage){
        this.countPages = countPages;
        this.countPhotosOnPage = countPhotosOnPage;
        this.pages = new Page[countPages];
    }

    public boolean isFullAlbum(Object []obj) {
        Page[] page = (Page[])obj;
        if (page.length == this.numberPage+1 && page[this.numberPage].countAddPhotos() == page[this.numberPage].photos.length && this.countPhotosOnPage !=0){
            return true;
        }
        return false;
    }
    public void changeNamePhoto(int numberPage, int numberPhoto, String namePhoto){
        if(pages.length <= numberPage || this.countPhotosOnPage <= numberPhoto){
            System.out.println("№ страницы или № фотографии - не существует");
        }
        else {
            pages[numberPage].photos[numberPhoto].photoName = namePhoto;
        }
    }
    public void countPhotoInAlbum(){
        int numberPage = 0;
        int countAllPhoto = 0;
        while (pages.length > numberPage && null != pages[numberPage]){
            countAllPhoto = countAllPhoto + pages[numberPage].countAddPhotos();
            numberPage++;
        }
        System.out.println("Количество добавленных фотографий в альбоме: " + countAllPhoto);
    }

    public void addPhoto(String namePhoto) {
        int countPhotosOnPage = this.countPhotosOnPage;
        int numberPage = this.numberPage;
        if (isFullAlbum(pages) != true) {
            if (pages[numberPage] != null) {
                if(pages[numberPage].isFullPage(pages[numberPage])) {
                    numberPage++;
                    pages[numberPage] = new Page(countPhotosOnPage, numberPage);
                    pages[numberPage].addPhoto(namePhoto);
                }
                else {
                    pages[numberPage].addPhoto(namePhoto);
                }
            } else {
                pages[numberPage] = new Page(countPhotosOnPage, numberPage);
                pages[numberPage].addPhoto(namePhoto);
            }
        }
        else{
            System.out.println("Альбом полностью заполнен - нет возможности добавить 1 фото с названием: " + namePhoto);
        }
        this.numberPage = numberPage;
    }
}
