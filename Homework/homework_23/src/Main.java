import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //String[] arrayS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        //List list = Arrays.asList(array);
        ArrayList<Integer>list1 = new ArrayList<>(Arrays.asList(array));
        Integer myArray[] = list1.toArray(new Integer[list1.size()]);
        Integer[] res = (Arrays.copyOf(myArray, 5));
        ArrayList <Integer>list2 = new ArrayList<>(Arrays.asList(res));

        //ArrayList list1 = new ArrayList<>(Arrays.asList(arrayS));
        //ArrayList<Integer> arrayList = new ArrayList<>(list);


    }
}
