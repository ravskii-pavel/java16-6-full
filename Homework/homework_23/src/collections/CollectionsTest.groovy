package collections

import spock.lang.Specification

/*import java.util.Arrays;
import java.util.Collections;*/

/**
 * Created by Ravskiy Pavel on 05.02.2017.
 */
class CollectionsTest extends Specification {

    def "copy() test1"() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i + "");
        }

        List<String> result = new ArrayList<>(list.size());
        for (int i = 1; i <= list.size(); i++) {
            result.add("1");
        }

        when:
        Collections.copy(result, list);

        then:
        result == ["1", "2", "3", "4", "5"];
    }

    def "disjoint() test1"() {
        List<String> list = new ArrayList<>();
        for (int i = 2; i <= 5; i++) {
            list.add(i + "");
        }

        List<String> result = new ArrayList<>(list.size());
        for (int i = 1; i <= list.size(); i++) {
            result.add("1");
        }

        when:
        boolean res = Collections.disjoint(result, list);

        then:
        res == true;
    }

    def "fill() test1"() {
        List<String> list = new ArrayList<>();
        for (int i = 2; i <= 5; i++) {
            list.add(i + "");
        }

        when:
        Collections.fill(list, "7");

        then:
        list == ["7", "7", "7", "7", "7"];
    }

    def "frequency() test1"() {
        List<String> list = new ArrayList<>();
        for (int i = 2; i <= 5; i++) {
            list.add(i + "");
        }
        list.add("5");
        list.add("5");

        when:
        int res = Collections.frequency(list, "5");

        then:
        res == 3;
    }

    def "indexOfSubList() test1"() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i + "");
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

    def "lastIndexOfSubList() test1"() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i + "");
            list.add("88");
        }

        List<String> result = new ArrayList<>(list.size());
        result.add("88");

        when:
        int res = Collections.lastIndexOfSubList(list, result);

        then:
        res == 9;
    }

    def "max() test1"() {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        list.add(73);
        list.add(9);

        when:
        Integer max = 73;

        then:
        Collections.max(list) == max;
    }

    def "max() test2 - String"() {

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i + "");
            list.add("88");
        }
        list.add("8");
        list.add("A");
        list.add("c");
        list.add("w");
        list.add("a");

        when:
        String max = "w";

        then:
        max.equals(Collections.max(list));
    }

    def "min() test1"() {

        List<Integer> list = new ArrayList<>();
        for (int i = 7; i <= 15; i++) {
            list.add(i);
        }
        list.add(4);
        list.add(9);

        when:
        Integer min = 4;

        then:
        Collections.min(list) == min;
    }

    def "nCopies() test1"() {
        int coutCopies = 7;
        List<String> list = new LinkedList<>();
        list = Collections.nCopies(coutCopies, "Copies of String");

        when:
        List<String> result = new LinkedList<>();
        for (int i = 0; i < coutCopies; i++) {
            result.add("Copies of String");
        }

        then:
        result.equals(list);
    }

    def "replaceAll() test1"() {
        int coutCopies = 4;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < coutCopies; i++) {
            list.add("45");
        }

        when:
        List<String> result = new ArrayList<>();
        result = Collections.nCopies(coutCopies, "New element");
        Collections.replaceAll(list, "45", "New element");

        then:
        list.equals(result);
    }

    def "reverse() test1"() {
        List<Integer> list = new ArrayList<>();
        for (int i = 7; i <= 15; i++) {
            list.add(i);
        }

        when:
        Collections.reverse(list);

        then:
        list.equals([15, 14, 13, 12, 11, 10, 9, 8, 7]);
    }

    def "reverseOrder() test1"() {
        List<Integer> list = new ArrayList<>();
        for (int i = 7; i <= 11; i++) {
            list.add(i);
            list.add(-19 + i)
        }
        Comparator cmp = Collections.reverseOrder();

        when:
        Collections.sort(list, cmp);

        then:
        list.equals([11, 10, 9, 8, 7, -8, -9, -10, -11, -12]);
    }

    def "rotate() test1"() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 15; i++) {
            list.add(i);
        }

        when:
        Collections.rotate(list, 6);

        then:
        list.equals([10, 11, 12, 13, 14, 15, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]);
    }
    def "rotate() test2"() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 15; i++) {
            list.add(i);
        }

        when:
        Collections.rotate(list, -6);

        then:
        list.equals([6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0, 1, 2, 3, 4, 5]);
    }

    def "shuffle() test1"() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 15; i++) {
            list.add(i);
        }
        when:
        Collections.shuffle(list);

        then:
        list.size() == 16;
    }

    def "sort() test1"() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            list.add(i);
            list.add(83);
        }

        when:
        Collections.sort(list);

        then:
        list == ([0, 1, 2, 3, 4, 5, 83, 83, 83, 83, 83, 83]);
    }
    def "swap() test1"() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            list.add(i);
        }

        when:
        Collections.swap(list, 1, 4);

        then:
        list == ([0, 4, 2, 3, 1, 5]);
    }
}
/*
Arrays.sort(list.toArray(new String[list.size()]), new Comparator<String>() {
    public int compare(String str1, String str2) {
        return str1.compareTo(str2.toString());
    }*/
