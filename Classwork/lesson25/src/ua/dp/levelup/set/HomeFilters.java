package ua.dp.levelup.set;

import java.util.Comparator;

/**
 * Created by java on 10.02.2017.
 */
public class HomeFilters {

    public static Comparator<Home> streetComparator(){
        return new Comparator<Home>() {
            @Override
            public int compare(Home h1, Home h2) {
                int homeNumbers = Integer.compare(h1.getNumber(), h2.getNumber());
                int streetNames = h1.getStreetName().compareToIgnoreCase(h2.getStreetName());

                if(homeNumbers == 0 && streetNames == 0) return 0; //remove duplicates
                else if (homeNumbers == 0) return streetNames;
                else return streetNames == 0 ? homeNumbers : streetNames;
            }
        };
    }
}
