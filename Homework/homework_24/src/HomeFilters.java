import java.util.Comparator;

/**
 * Created by Ravskiy Pavel on 19.02.2017.
 */
public class HomeFilters {
    public static Comparator<Home> streetComparator() {
        return new Comparator<Home>() {
            @Override
            public int compare(Home h1, Home h2) {
                int homeNumbers = Integer.compare(h1.getHouseNumber(), h2.getHouseNumber());
                int streetNames = h1.getStreetName().compareToIgnoreCase(h2.getStreetName());

                if (homeNumbers == 0 && streetNames == 0) return 0; //remove duplicates
                else if (homeNumbers == 0) return streetNames;
                else return streetNames == 0 ? homeNumbers : streetNames;
            }
        };
    }

    public static Comparator<Home> homeNumbersComparator() {
        return new Comparator<Home>() {

            @Override
            public int compare(Home h1, Home h2) {
                int homeNumbers = Integer.compare(h1.getHouseNumber(), h2.getHouseNumber());
                int streetNames = h1.getStreetName().compareToIgnoreCase(h2.getStreetName());

                if (homeNumbers == 0 && streetNames == 0) return 0; //remove duplicates
                else if (streetNames == 0) {
                    return homeNumbers;
                }
                else return homeNumbers == 0 ? streetNames : homeNumbers;
            }
        };
    }

    public static Comparator<Home> peopleInHouseComparator() {
        return new Comparator<Home>() {

            @Override
            public int compare(Home h1, Home h2) {
                int homeNumbers = Integer.compare(h1.getHouseNumber(), h2.getHouseNumber());
                int streetNames = h1.getStreetName().compareToIgnoreCase(h2.getStreetName());
                int peopleInHouse = Integer.compare(h1.getQuantityPeopleInHouse(), h2.getQuantityPeopleInHouse());

                if (homeNumbers == 0 && streetNames == 0) return 0; //remove duplicates
                else if (peopleInHouse == 0 && streetNames ==0) {
                    return homeNumbers;
                }
                else {
                    return peopleInHouse == 0 ? streetNames : peopleInHouse;
                }
            }
        };
    }
}
