package list;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by java on 07.02.2017.
 */
public class UtilTest {

    @Test
    public void testArraysCopyOf(){
        String[] arr = {"a", "a", "v", "b"};
        String[] arr2 = Arrays.copyOf(arr, arr.length);


        /*System.out.println(Arrays.binarySearch(arr, "a"));
        System.out.println(Arrays.binarySearch(arr, "e"));
        System.out.println(Arrays.toString(arr2));*/

        assertTrue(Arrays.equals(arr,arr2));
        System.out.println(Arrays.binarySearch(arr, "a"));


    }
    @Test
    public void testArraysAsList(){

        String[] arr = {"a", "a", "v", "b"};
        List<String> list = new ArrayList<>();
        for(String s: arr) list.add(s);

        //ArrayList<String> list2 = (ArrayList<String>) Arrays.asList(arr);!!!!!!!!!

        List<String> list2 = Arrays.asList(arr);
        List<String> list3 = Arrays.asList("f", "g", "h", "c", "88");

        System.out.println(Arrays.binarySearch(arr, "a"));

        Collections.copy(list3, list); // из list  list3
        list3.forEach(System.out::println);






    }
    @Test
    public void testHashSet() {

        Set<Integer> integerSet = new HashSet<>();

        integerSet.add(1);
        integerSet.add(new Integer(1));
        integerSet.add(new Integer(2));
        integerSet.add(2);
        integerSet.add(77);
        integerSet.add(8);
        integerSet.add(8);
        integerSet.add(1);
        integerSet.add(1);
        System.out.println(integerSet.toString());

        Set<String> hash = new HashSet<>();
        hash.add("castlle");
        hash.add("bridge");
        hash.add("castlle");
        hash.add("moat");

        System.out.println(hash);

        int id = 525;

/*        Set<Student> students = new HashSet<>();
        students.add(new Student(id + 4,"Bill", 24));
        students.add(new Student(id + 1,"Sam", 22));
        students.add(new Student(id + 3,"Tom", 22));
        students.add(new Student(id + 1,"Sam", 22));
        students.add(new Student(id + 3,"Sam", 22));
        students.add(new Student(id + 2,"Bob", 22));*/

/*        Set<Student> students = new LinkedHashSet<>(); // сохраняется порядок вставки
        students.add(new Student(id + 4,"Bill", 24));
        students.add(new Student(id + 1,"Sam", 22));
        students.add(new Student(id + 3,"Tom", 22));
        students.add(new Student(id + 1,"Sam", 22));
        students.add(new Student(id + 3,"Sam", 22));
        students.add(new Student(id + 2,"Bob", 22));*/

        Set<Student> treeSet = new TreeSet<>(filterByAge()); // сохраняется порядок вставки
        treeSet.add(new Student(id + 4,"Bill", 24));
        treeSet.add(new Student(id + 1,"Sam", 22));
        treeSet.add(new Student(id + 3,"Tom", 22));
        treeSet.add(new Student(id + 1,"Sam", 22));
        treeSet.add(new Student(id + 3,"Sam", 22));
        treeSet.add(new Student(id + 2,"Bob", 22));

        System.out.println(treeSet.size());


        System.out.println(treeSet);
    }

    private Comparator<Student> filterByAge() {
        return (o1, o2) -> Integer.compare(o1.getAge(), o2.getAge());
    }
}
