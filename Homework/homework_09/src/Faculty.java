/**
 * Created by ravskiy on 06.12.2016.
 */
public enum Faculty {
    GRYFFINDOR("Gryffindor","Гриффиндор"),
    SLYTHERIN("Slytherin","Слизерин"),
    HUFFLEPUFF("Hufflepuff","Пуффендуй"),
    RAVENCLAW("Ravenclaw","Когтевран");

    String nameEn;
    String nameRu;

    Faculty(String nameEn, String nameRu){
        this.nameEn = nameEn;
        this.nameRu = nameRu;
    }
}
