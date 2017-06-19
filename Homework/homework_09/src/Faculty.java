import java.util.Random;

/**
 * Created by ravskiy on 06.12.2016.
 */

/* 2) Объявить класс перечислений Faculty у которого будут свойства nameEn(строка), nameRu(строка),
     и элементы перечисления: GRYFFINDOR, SLYTHERIN, HUFFLEPUFF, RAVENCLAW.*/

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

    /* 5) Написать программу, которая случайным образом возвращает факультет в виде перечисления:
    GRYFFINDOR, SLYTHERIN, HUFFLEPUFF, RAVENCLAW. * Использовать для выполнения метод nextInt(),
    который можно вызвать у экземпляра класса Random.*/
   public static Faculty getRandomFaculty (){
        Random random = new Random();
        return Faculty.values()[random.nextInt(Faculty.values().length)];
    }

}
