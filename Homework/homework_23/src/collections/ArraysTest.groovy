package collections

/*
import java.util.Arrays;
import java.util.Collections;
*/

/**
 * Created by Ravskiy Pavel on 05.02.2017.
 */
class ArraysTest extends spock.lang.Specification {

    def "copyOf() test1"() {
        Collection list1 = new ArrayList<>();
        Collection result;

        for (int i = 0; i < 10; i++){
            list1.add(i);
        }


        when:
        result = Arrays.copyOf(list1, 4);

        then:
        result == [0, 1, 2, 3];

    }


}
