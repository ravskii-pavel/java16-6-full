import com.sun.org.apache.bcel.internal.generic.LAND;

public class Main {

    public static void main(String[] args) {
       /* 1) Создать объект класса Щенок, используя классы Животное, Собака. Методы: вывести на консоль имя, подать голос,
         прыгать, бегать, кусать.*/

        Puppy puppy = new Puppy("Brjus");

        puppy.name();
        puppy.barking();
        puppy.bite();
        puppy.jump();
        puppy.movement();
        Album album = new Album(5);
        album.addPhoto("My FAMILY");
        album.addPhoto("My Dog");
        album.addPhoto("My Cat");

       /* 2) Создать объект класса Фотоальбом, используя классы Фотография, Страница. Методы: задать название фотографии,
       дополнить фотоальбом фотографией, вывести на консоль количество фотографий.*/



    }


}
