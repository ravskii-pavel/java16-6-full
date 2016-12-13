/**
 * Created by Pavel on 09.12.2016.
 */
public class Album {
    int countPhotoesOnPage;
    int numberPage;
    Page []pages = new Page[10];

    Album (int countPhotoesOnPage){
        this.countPhotoesOnPage = countPhotoesOnPage;
        this.numberPage = 0;
    }

    public void setPhoto(String namePhoto){
        if (this.pages != null) {
            this.pages[numberPage]. ;
            numberPage++;
        }
        else{
            System.out.println("Нет места для фото");
        }
    }
}
