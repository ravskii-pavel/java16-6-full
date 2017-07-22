package ua.com.tickets.core.model.filters;


import ua.com.tickets.core.model.MovieSession;

import java.util.Calendar;
import java.util.Comparator;

public class MovieSessionFilter {
    public Comparator<MovieSession> sessionDayComparator() {
        return new Comparator<MovieSession>() {
            @Override
            public int compare(MovieSession ms1, MovieSession ms2) {
                int yearSessions = Integer.compare(ms1.getSessionStartDate().get(Calendar.YEAR), (ms2.getSessionStartDate().get(Calendar.YEAR)));
                int monthSessions = Integer.compare(ms1.getSessionStartDate().get(Calendar.MONTH), (ms2.getSessionStartDate().get(Calendar.MONTH)));
                int daySessions = Integer.compare (ms1.getSessionStartDate().get(Calendar.DAY_OF_MONTH), (ms2.getSessionStartDate().get(Calendar.DAY_OF_MONTH)));

                if (yearSessions == 0 && monthSessions == 0 && daySessions == 0) return 0; //remove duplicates
                else if (yearSessions == 0 && monthSessions == 0) return daySessions;
                else if (yearSessions == 0) return monthSessions;
                else return yearSessions;
            }
        };
    }

/*    public static Comparator<Home> homeNumbersComparator() {
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
        };*/
    //}
}
