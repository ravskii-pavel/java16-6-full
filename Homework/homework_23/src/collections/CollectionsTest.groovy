package collections

import spock.lang.Specification

/*import java.util.Arrays;
import java.util.Collections;*/

/**
 * Created by Ravskiy Pavel on 05.02.2017.
 */
class CollectionsTest extends Specification {

    def "copy() test1"() {
        List <String> list = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            list.add(i+"");
        }

        List<String> result = new ArrayList<>(list.size());
        for(int i = 1; i <= list.size(); i++){
            result.add("1");
        }

        when:
        Collections.copy(result, list);

        then:
        result == ["1", "2", "3", "4", "5"];
    }
    def "disjoint() test1"() {
        List <String> list = new ArrayList<>();
        for(int i = 2; i <= 5; i++){
            list.add(i+"");
        }

        List<String> result = new ArrayList<>(list.size());
        for(int i = 1; i <= list.size(); i++){
            result.add("1");
        }

        when:
        boolean res = Collections.disjoint(result, list);

        then:
        res == true;
    }
    def "fill() test1"() {
        List <String> list = new ArrayList<>();
        for(int i = 2; i <= 5; i++){
            list.add(i+"");
        }

        when:
        Collections.fill(list, "7");

        then:
        list == ["7", "7", "7", "7", "7"];
    }
    def "frequency() test1"() {
        List <String> list = new ArrayList<>();
        for(int i = 2; i <= 5; i++){
            list.add(i+"");
        }
        list.add("5");
        list.add("5");

        when:
        int res = Collections.frequency(list, "5");

        then:
        res == 3;
    }
    def "indexOfSubList() test1"() {
        List <String> list = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            list.add(i+"");
        }

        List<String> result = new ArrayList<>(list.size());
        result.add("3");
        result.add("4");
        result.add("5");

        when:
        int res = Collections.indexOfSubList(list, result);

        then:
        res == 2;
    }

}
