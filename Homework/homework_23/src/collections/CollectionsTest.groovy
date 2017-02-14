package collections

import spock.lang.Specification

/*import java.util.Arrays;
import java.util.Collections;*/

/**
 * Created by Ravskiy Pavel on 05.02.2017.
 */
class CollectionsTest extends Specification {

    def "copy() test2"() {
        List <String> list = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            list.add(i+"");
        }
        List<String> result = new ArrayList<>(list.size());


        when:
        Collections.copy(list, result);

        then:
        result == ["1", "2", "3", "4", "5"];
    }


}
