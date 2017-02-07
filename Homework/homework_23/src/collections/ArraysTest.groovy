package collections
import spock.lang.Specification
import java.util.ArrayList;
/*
import java.util.Arrays;
import java.util.Collections;
*/

/**
 * Created by Ravskiy Pavel on 05.02.2017.
 */
class ArraysTest extends Specification {

    def "copyOf() test1"() {
        //Integer res[] =  new Integer();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i =0; i <  10; i++){
            list.add(i);
        }


    when:
      Integer[] res = Arrays.copyOf(list.toArray(new Integer[list.size()]), 5);


    then:
      res == [0, 1, 2, 3, 4];
    }


}
