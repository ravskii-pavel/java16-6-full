import java.util.*;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        //Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //String[] arrayS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        //List list = Arrays.asList(array);
        //ArrayList<Integer>list1 = new ArrayList<>(Arrays.asList(array));

        ArrayList<Integer> list = new ArrayList<>();

        for (int i =1; i <=10; i++){
            list.add(i);
        }

        Integer res[] = Arrays.copyOf(list.toArray(new Integer[list.size()]), 5);



        //Integer[] res = (Arrays.copyOf(myArray, 5));
        //ArrayList <Integer>list2 = new ArrayList<>(Arrays.asList(res));

       /* Integer myArray[] = list1.toArray(new Integer[list1.size()]);
        Integer[] res = (Arrays.copyOf(myArray, 5));
        ArrayList <Integer>list2 = new ArrayList<>(Arrays.asList(res));*/

        //ArrayList list1 = new ArrayList<>(Arrays.asList(arrayS));
        //ArrayList<Integer> arrayList = new ArrayList<>(list);


    }
}
