/**
 * Created by Pavel on 02.12.2016.
 */
/*Создать класс Book с полями: name (строка), bookType (перечисление), author (строка),
year (целое число). Написать конструктор со всеми параметрами. Опишите с помощью enum тип данных
для хранения литературных жанров (роман, сказка, комедия, драма, научная фантастика, детектив).
Создать объекты класса книга (число объектов соответствует числу жанров).*/

public class Book {

    public enum bookType{
        ROMAN
    }
    String name;
    String author;
    int year;
}
