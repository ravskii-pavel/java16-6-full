/**
 * Created by Pavel on 09.12.2016.
 */
public class Album {
    int numberPage = 0;
    int countPhotoesOnPage;
    int countPagesAll;
    Page []pages = new Page[countPagesAll];

    Album (int countPagesAll, int countPhotoesOnPage){
        this.countPhotoesOnPage = countPhotoesOnPage;
        this.countPagesAll = countPagesAll;
    }
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
        if (this.pages != null){

            this.pages[numberPage] = new Page(getCountPhotoesOnPage());
            //numberPage++;.addPhoto(namePhoto, numberPage, countPhotoesOnPage);
        }
        else{
            System.out.println("Нет места для фото");
        }
    }
}
