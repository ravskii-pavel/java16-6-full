/**
 * Created by Pavel on 09.12.2016.
 */
public class Album {
    int numberPage = 0;
    int countPhotoesOnPage;
    int countPagesAll;
    Page []pages = new Page[countPagesAll];

    public void setCountPages(int countPages) {
        this.countPagesAll = countPages;
    }

    public void setCountPhotoesOnPage(int countPhotoesOnPage) {
        this.countPhotoesOnPage = countPhotoesOnPage;
    }

    public int getCountPhotoesOnPage() {
        return countPhotoesOnPage;
    }
    public int getCountPages() {
        return countPagesAll;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public void addPhoto(String namePhoto){

       /* countPhotoesAdd < countPhotoesOnPage * countPagesAll && countPhotoesAdd > 0 &&*/
        if (pages[numberPage]!= null) {
            pages[numberPage].addPhoto();
        }
        else {
                System.out.println("Введите др. количество фотографий");
            }
        }
    }
}
