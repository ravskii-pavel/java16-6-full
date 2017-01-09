/**
 * Created by java on 06.12.2016.
 */
public class Country {

    String name;
    int population;

    public int getPopulation() {
        return population;
    }
    Country(String name, int population){
        this.name = name;
        this.population = population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Country){
            Country country = (Country) obj;
            if(this.name != null && country.getName() != null)
            return country.getName().equals(this.name)&& country.getPopulation() == this.population;
        }

        return false;
    }
}
