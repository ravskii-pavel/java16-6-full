package ua.dp.leveluo.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;

/**
 * Created by java on 07.03.2017.
 */
public class Main {

    public static void main(String[] args) {
        Book book = new Book(17);
        book.setAuthor("Pushkin");
        book.setBookName("Book1");
        book.setPageCount(35);

        Class aClass = book.getClass(); //получение экземпляра класса

        Class bookClass = Book.class; //получение экземпляра класса


        System.out.println("Book fields");
        Field[] fields = bookClass.getFields(); // возвращает поля только с публичным доступом
        /*Method[] methods = bookClass.getMethods();

        for (Field field : fields) {
            System.out.println(field.getName());

        } for (Method method : methods) {
            System.out.println(method.getName());

        }*/

        Class c =  Book.class;
        Class[] interfaces = c.getInterfaces();

        System.out.println(interfaces[0]);

        for(Class cInterface : interfaces) {
            System.out.println( cInterface.getName() );
        }

        System.out.println("Book declaredFields");

        Field[] declaredFields = bookClass.getDeclaredFields();  // возвращает все поля
        Method[] declaredmethods = bookClass.getDeclaredMethods();

        for (Field field : declaredFields) {
            System.out.println(field.getName());
        }
        for (Method method : declaredmethods) {
            System.out.println(method.getName());
        }

        try {
           /* Field field = bookClass.getDeclaredField("author");

            String authorN = (String) field.get(book);
            System.out.println(authorN);

            field.set(book, "Gogol");
            String authorNew = (String) field.get(book);
            System.out.println(authorNew);*/

            Field field1 = null;
            try {
                field1 = bookClass.getDeclaredField("id");
            } catch (NoSuchFieldException e1) {
                e1.printStackTrace();
            }

           /* long a = (long) field1.get(bookClass);
            System.out.println(a);*/
            field1.setAccessible(true);
            field1.set(book, 44L);
            System.out.println(field1.get(book));


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

            /*field1.set(book, 44L);
            long bNew = (long) field1.get(bookClass);

            System.out.println(bNew);*/
        XMLParser parser = new XMLParser();
        String bookAsXML = parser.toXML(book);
        System.out.println(bookAsXML);


        Author author = new Author("John","Doe", 54);
        String authorAsXML = parser.toXML(author);

        System.out.println(authorAsXML);

    }
}
