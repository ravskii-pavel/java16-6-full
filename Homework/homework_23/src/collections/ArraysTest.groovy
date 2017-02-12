package collections

import spock.lang.Specification

import java.awt.List
import java.util.ArrayList;


/**
 * Created by Ravskiy Pavel on 05.02.2017.
 */
class ArraysTest extends Specification {

    def "copyOf() test1"() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =0; i <  10; i++){
            list.add(i);
        }

    when:
        Integer[] res = Arrays.copyOf(list.toArray(new Integer[list.size()]), 5);
        ArrayList<Integer> resultList = Arrays.asList(res);

    then:
        res == [0, 1, 2, 3, 4];
        resultList == [0, 1, 2, 3, 4];
    }
    def "copyOf() test2"() {
        ArrayList<String> list = ["11", "22", "33", "44", "55", "66", "77", "88", "99"];

        when:
        String []result = Arrays.copyOf(list.toArray(new String[list.size()]), 4);
        ArrayList<String> resultList = Arrays.asList(result);

        then:
        result == ["11", "22", "33", "44"];
        resultList ==  ["11", "22", "33", "44"];
    }
    def "copyOfRange() test1"() {
        String [] mass = ["11", "22", "33", "44", "55", "66", "77", "88", "99"];

        when:
        String []result = Arrays.copyOfRange(mass, 1, 5);

        then:
        result == ["22", "33", "44", "55"];
    }
    def "copyOfRange() test2"() {
        ArrayList<String> list = ["11", "22", "33", "44", "55", "66", "77", "88", "99"];

        when:
        String []result = Arrays.copyOfRange(list.toArray(new String[list.size()]), 1, 5);
        ArrayList<String> resultList = Arrays.asList(result);

        then:
        resultList == ["22", "33", "44", "55"];
    }
    def "sort() test1 - String"() {
        ArrayList<String> list = ["44", "11", "33", "22", "88", "66", "77", "55", "99"];
        String[] res = list.toArray(new String[list.size()]);
        Arrays.sort(res);

        when:
        ArrayList<String> result =  Arrays.asList(res);

        then:
        result == ["11", "22", "33", "44", "55", "66", "77", "88", "99"];
    }
    def "sort() test2 - Integer"() {
        ArrayList<Integer> list = [44, 11, 33, 22, 88, 66, 77, 55, 99];
        Integer[] res = list.toArray(new Integer[list.size()]);
        Arrays.sort(res);

        when:
        ArrayList<Integer> result =  Arrays.asList(res);

        then:
        result == [11, 22, 33, 44, 55, 66, 77, 88, 99];
    }
    def "toString() test1 - Integer"() {

        Collection<Integer> list = new ArrayList<>();
        for(int i = 1; i<=10; i++){
            list.add(i);
        }
        println (Arrays.toString(list));

        when:
        String result = Arrays.toString(list);

        then:
        result == "[[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]]";
    }
    def "binarySearch() test1 - Integer"() {

        LinkedList<Integer> list = new LinkedList<>();
        list = [44, 11, 33, 22, 88, 66, 77, 55, 99];
        list.sort();

        when:
        int result = Arrays.binarySearch(list.toArray(new Integer[list.size()]), 44);
        int result1 = Arrays.binarySearch(list.toArray(new Integer[list.size()]), 37);

        then:
        result == 3;
        result1 == -4; // порядковый номер на который мог бы стать ненайденный искомый элемент
    }
    def "fill() test1 - Integer"() {

        ArrayList<Integer> list = [44, 11, 33, 22, 88];
        list.sort();

        when:
        Integer [] res = list.toArray(new Integer[list.size()]);
        Arrays.fill(res, 777);
        //int result1 = Arrays.binarySearch(list.toArray(new Integer[list.size()]), 37);

        then:
        res.equals([777, 777, 777, 777, 777]);
        //result1 == -4; // порядковый номер на который мог бы стать ненайденный искомый элемент
    }



    /* Arrays.sort(list.toArray(new String[list.size()]), new Comparator<String>() {
         public int compare(String str1, String str2) {
             return str1.compareTo(str2.toString());
         }
     });*/


}
