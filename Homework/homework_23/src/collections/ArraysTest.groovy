package collections
import java.util.ArrayList;
/*
import java.util.Arrays;
import java.util.Collections;
*/

/**
 * Created by Ravskiy Pavel on 05.02.2017.
 */
class ArraysTest extends spock.lang.Specification {

    def "copyOf() test1"() {

        Integer[] array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
        //List list = Arrays.asList(array);
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(array));
        //ArrayList<Integer> arrayList = new ArrayList<>(list);

        /*ArrayList l1 = new ArrayList<>();
        ArrayList res = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            l1.add(i);
        }
*/

      when:

      ArrayList res = Arrays.copyOf(list1,4);


        then:
        res == [0, 1, 2, 3];

    }


}
