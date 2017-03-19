import spock.lang.Specification
import ua.dp.levelup.set.Home

import static ua.dp.levelup.set.HomeFilters.streetComparator

public class HomeFilterTest extends Specification{

    List<Home> list = Arrays.asList(
            new Home(1, "Gagaryna", 2,4),
            new Home(2, "Lenyna", 2,4),
            new Home(3, "Panikahi", 2,4),
            new Home(4, "Rabochaya", 2,4),
            new Home(5, "Glinki", 2,4),
            new Home(2, "Glinki", 2,4),
            new Home(6, "Artema", 2,4),
            new Home(1, "Gagaryna", 2,4),
            new Home(4, "Rabochaya", 2,4),
            new Home(1, "Gagaryna", 2,4),
            new Home(2, "Lenyna", 2,4),

    );
    def 'chek streetName comparator'(){

        when:
        Set<Home> homeSet = new TreeSet<>(streetComparator());
        homeSet.addAll(list);
        println (homeSet.size() + " " + homeSet);

        then:
        homeSet.size() == 7;
    }


}