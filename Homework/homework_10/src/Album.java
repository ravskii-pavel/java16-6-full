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

    public int getNumberPhoto() {
        return numberPhoto;
    }

    public void setPhoto(String namePhoto){
        if (this.pages != null) {
            pages[numberPage] = new Page(countPhotoesOnPage, numberPage);
            pages[numberPage].setPhoto(namePhoto, getNumberPhoto());
            this.numberPhoto++;
        }
        else{
            System.out.println("Нет места для фото");
        }
    }
}
