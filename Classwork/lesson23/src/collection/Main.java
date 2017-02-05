package collection;

import javafx.print.Collation;

import java.util.*;

/**
 * Created by java on 03.02.2017.
 */
public class Main {
    public static void main(String[] args) {
   /* Collection list1 = new ArrayList<>();
        Collection list2 = new ArrayList<>();


    for (int i =1; i <=10; i++){
        list1.add(i);
    }
    list1.c
    list1.add(129);
    list2.add(129);
    for (int i = 1; i <=25; i++){
        list2.add(i);
    }

        Collection list3 = new ArrayList<>(list1);
        list3.addAll(list2);

        System.out.println(list1.size());
        System.out.println(list2.size());
        System.out.println(list3.size());

        Integer[] array = (Integer[]) list1.toArray(new Integer[list1.size()]);
        System.out.println(Arrays.toString(array));
    */

        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(6);
        list.add(5);
        list.add(4);

        System.out.println(list.get(3));
        System.out.println(list.get(5));

        for (int i =0; i<list.size(); i++){

            System.out.println(list.get(i));
        }

        //ListIterator<Integer> iter = list.listIterator();
       //while (iter.hasNext()) System.out.println(iter.next());

    }
}
