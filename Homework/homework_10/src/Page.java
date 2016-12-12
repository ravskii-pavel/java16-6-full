/**
 * Created by Pavel on 09.12.2016.
 */
public class Page {

    int numberPage = 0;
    int countOfPhotoes;
    int countAdds = 0;
    Photo [] photoes = new Photo[countOfPhotoes];

    Page(int numberPage, String namePhoto) {
        this.numberPage = numberPage;
        this.photoes = photoes;
    }

    //public void setNumberOfPage(int numberOfPage) {
        this.numberPage = numberOfPage;
    }

    public void addPhoto(String namePhoto){

        if (countAdds < countOfPhotoes){
            photoes[number]= new Photo (numberPage, "New photo");
        }
        setNummberPage(numberPage);
    }
}
