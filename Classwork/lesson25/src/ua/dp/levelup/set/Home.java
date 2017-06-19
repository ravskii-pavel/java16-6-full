package ua.dp.levelup.set;

/**
 * Created by java on 10.02.2017.
 */
public class Home {

    private int number;
    private String streetName;
    private int stageCount;

    public Home(int number, String streetName, int stageCount, int citizens) {
        this.number = number;
        this.streetName = streetName;
        this.stageCount = stageCount;
        this.citizens = citizens;
    }

    private int citizens;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Home)) return false;

        Home home = (Home) o;

        if (getNumber() != home.getNumber()) return false;
        return getStreetName().equals(home.getStreetName());

    }

    @Override
    public int hashCode() {
        int result = getNumber();
        result = 31 * result + getStreetName().hashCode();
        return result;
    }

    public void setNumber(int number) {

        this.number = number;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStageCount(int stageCount) {
        this.stageCount = stageCount;
    }

    public void setCitizens(int citizens) {
        this.citizens = citizens;
    }

    public int getNumber() {

        return number;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getStageCount() {
        return stageCount;
    }

    public int getCitizens() {
        return citizens;
    }

    @Override
    public String toString() {
        return "Home{" +
                "number=" + number +
                ", streetName='" + streetName + '\'' +
                ", stageCount=" + stageCount +
                ", citizens=" + citizens +
                '}';
    }
}
