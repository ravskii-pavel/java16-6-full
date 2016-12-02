/**
 * Created by Pavel on 02.12.2016.
 */
/*9) Создать класс Book с полями: name (строка), bookType (перечисление), author (строка),
year (целое число). Написать конструктор со всеми параметрами. Опишите с помощью enum тип данных
для хранения литературных жанров (роман, сказка, комедия, драма, научная фантастика, детектив).
Создать объекты класса книга (число объектов соответствует числу жанров).*/

public class Book {

    String name;
    String author;
    int year;
    bookType style;

    Book (bookType style, String name, String author, int year){
        this.style = style;
        this.name = name;
        this.author = author;
        this.year = year;
    }
}
enum bookType{
    NOVEL,
    FAIRYTALE,
    COMEDY,
    DRAMA,
    SCIENCE_FICTION,
    DETECTIVE;
}