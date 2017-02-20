import java.util.*;

//import static HomeFilters.streetComparator;

public class Main {

    public static void main(String[] args) {

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

       /* Set<Home> homeSet = new TreeSet<>(streetComparator());
        homeSet.addAll(list);

        for (Home s : homeSet){
            System.out.println(s);
        }
        System.out.println();
        Iterator<Home> itr= homeSet.iterator();
        while(itr.hasNext()){
            Home c = itr.next();
            System.out.println(c);
        }
*/
    }

   /* public static Comparator<Home> streetComparator(){
        return new Comparator<Home>() {
            @Override
            public int compare(Home h1, Home h2) {
                int homeNumbers = Integer.compare(h1.getHouseNumber(), h2.getHouseNumber());
                int streetNames = h1.getStreetName().compareToIgnoreCase(h2.getStreetName());

                if(homeNumbers == 0 && streetNames == 0) return 0; //remove duplicates
                else if (homeNumbers == 0) return streetNames;
                else return streetNames == 0 ? homeNumbers : streetNames;
            }
        };
    }*/
}
