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

       /* 2 Создать объект класса Фотоальбом, используя классы Фотография, Страница. Методы: задать название фотографии,
       дополнить фотоальбом фотографией, вывести на консоль количество фотографий.*/
        Album album = new Album(3, 4);
        album.addPhoto("My FAMILY");
        album.addPhoto("Pink Floyd");
        album.addPhoto("Pink Floyd");
        album.addPhoto("Pink Floyd");
        album.addPhoto("Pink Floyd");
        album.addPhoto("Pink Floyd");
        album.addPhoto("Pink Floyd");
        album.addPhoto("Pink Floyd");
        album.addPhoto("Pink Floyd");

        System.out.println(album.pages[0].photos[0].photoName);
        album.changeNamePhoto(0, 0, "HAPPY FAMILY");
        album.countPhotoInAlbum();

        //System.out.println(album.pages[0].photos[0].photoName);

        /*3) Создать объект класса Звездная система, используя классы Планета, Звезда, Луна.
        Методы: вывести на консоль количество планет в звездной системе, название звезды,
        добавление планеты в систему.*/

        StarSystem starSystem = new StarSystem("SolarSystem", "Sun", 10);


    }


}
