/**
 * Created by Ravskiy Pavel on 19.02.2017.
 */
public class Home {
    int houseNumber;
    int quantityFloors;
    int quantityPeopleInHouse;
    String streetName;

    public Home(String streetName, int houseNumber, int quantityFloors, int quantityPeopleInHouse) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.quantityFloors = quantityFloors;
        this.quantityPeopleInHouse = quantityPeopleInHouse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Home)) return false;

        Home home = (Home) o;

        if (getHouseNumber() != home.getHouseNumber()) return false;
        if (getQuantityFloors() != home.getQuantityFloors()) return false;
        if (getQuantityPeopleInHouse() != home.getQuantityPeopleInHouse()) return false;
        return getStreetName().equals(home.getStreetName());
    }

    @Override
    public int hashCode() {
        int result = getHouseNumber();
        result = 31 * result + getStreetName().hashCode();
        return result;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getQuantityFloors() {
        return quantityFloors;
    }

    public void setQuantityFloors(int quantityFloors) {
        this.quantityFloors = quantityFloors;
    }

    public int getQuantityPeopleInHouse() {
        return quantityPeopleInHouse;
    }

    public void setQuantityPeopleInHouse(int quantityPeopleInHouse) {
        this.quantityPeopleInHouse = quantityPeopleInHouse;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public String toString() {
        return "Home{" +
                "houseNumber=" + houseNumber +
                ", quantityFloors=" + quantityFloors +
                ", quantityPeopleInHouse=" + quantityPeopleInHouse +
                ", streetName='" + streetName + '\'' +
                '}';
    }


}
