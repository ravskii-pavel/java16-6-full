import com.sun.org.apache.bcel.internal.generic.LAND;

import java.util.Objects;

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
        Album album = new Album(0);
        album.setPhoto("My FAMILY");
        album.setPhoto("My Dog");
        album.setPhoto("My Cat");
        album.setPhoto("My Cat");
        album.setPhoto("My Cat");
        album.setPhoto("My Cat+++++++++++++");
        album.setPhoto("NEW photo");

            System.out.println(album.pages[0].photos[0].photoName);
            System.out.println(album.pages[0].photos[1].photoName);
            System.out.println(album.pages[0].photos[2].photoName);
            System.out.println(album.pages[1].photos[0].photoName);
            System.out.println(album.pages[1].photos[1].photoName);
            System.out.println(album.pages[1].photos[2].photoName);

       /* 2) Создать объект класса Фотоальбом, используя классы Фотография, Страница. Методы: задать название фотографии,
       дополнить фотоальбом фотографией, вывести на консоль количество фотографий.*/



    }


}
