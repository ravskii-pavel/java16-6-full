import java.lang.reflect.Array

import static HomeFilters.homeNumbersComparator
import static HomeFilters.streetComparator
import static HomeFilters.peopleInHouseComparator

/**
 * Created by Ravskiy Pavel on 19.02.2017.
 */
class HomeFiltersTest extends spock.lang.Specification {

    List<Home> list = Arrays.asList(
        new Home("Gagarina", 101, 9, 107),
        new Home("Kirova",  89, 5, 71),
        new Home("Kazakova", 73, 9, 114),
        new Home("Titova",  101, 9, 107),
        new Home("Yantarnaya", 55, 9, 107),
        new Home("Artema",  101, 12, 140),
        new Home("Artema",  102, 12, 133),
        new Home("Artema",  102, 10, 133),
        new Home("Artema",  102, 9, 133),
        new Home("Artema",  89, 9, 99),
        new Home("Kirova",  11, 5, 67),
        new Home("Gagarina", 130, 9, 120)
    );

    def 'chek streetName comparator'(){

        when:
        Set<Home> homeSet = new TreeSet<>(streetComparator());
        //Set<Home> homeSet = new TreeSet<>();
        homeSet.addAll(list);
        for (Home s : homeSet){
            System.out.println(s);
        }

        then:
        homeSet.size() == 10;
    }
    def 'chek homeNumbers comparator'(){

        when:
        Set<Home> homeSet = new TreeSet<>(homeNumbersComparator());
        //Set<Home> homeSet = new TreeSet<>();
        homeSet.addAll(list);
        for (Home s : homeSet){
            System.out.println(s);
        }

        then:
        homeSet.size() == 10;
    }
    def 'chek quantity People InHouse comparator'(){

        when:
        Set<Home> homeSet = new TreeSet<>(peopleInHouseComparator());
        //Set<Home> homeSet = new TreeSet<>();
        homeSet.addAll(list);
        for (Home s : homeSet){
            System.out.println(s);
        }

        then:
        homeSet.size() == 10;
    }

    def 'chek streetName (HashSet) comparator'(){

        when:
        Set<Home> homeSet = new HashSet<>();
        //Set<Home> homeSet = new TreeSet<>();
        //homeSet.addAll(list.sort(streetComparator()));
        homeSet.addAll(list);
        streetComparator(homeSet);
        for (Home s : homeSet){
            System.out.println(s);
        }

        then:
        homeSet.size() == 11;
    }
}
