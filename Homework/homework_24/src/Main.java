import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//import java.util.Comparator;


/*import static HomeFilters.homeNumbersComparator;
import static HomeFilters.streetComparator;
import static HomeFilters.peopleInHouseComparator;*/

public class Main {

    public static void main(String[] args) {

        List<Home> list = Arrays.asList(
                new Home("Gagarina", 101, 9, 107),
                new Home("Kirova", 89, 5, 71),
                new Home("Kazakova", 73, 9, 114),
                new Home("Titova", 101, 9, 107),
                new Home("Yantarnaya", 55, 9, 107),
                new Home("Artema", 101, 12, 140),
                new Home("Artema", 102, 12, 133),
                new Home("Artema", 102, 10, 133),
                new Home("Artema", 102, 9, 133),
                new Home("Artema", 89, 9, 99),
                new Home("Kirova", 11, 5, 67),
                new Home("Gagarina", 130, 9, 120)
        );
        HomeFilters homeFilters = new HomeFilters();
         Collections.sort(list, homeFilters.streetComparator());
        System.out.println(list);
    }

}
