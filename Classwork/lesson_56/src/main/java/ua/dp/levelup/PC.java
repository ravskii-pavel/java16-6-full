package ua.dp.levelup;

/**
 * Created by java on 16.06.2017.
 */
public class PC {

    public String hdd;
    public String ram;
    public User owner;

    public void setRam(String ram) {
        this.ram = ram;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    @Override
    public String toString() {
        return "PC{" +
                "hdd='" + hdd + '\'' +
                ", ram='" + ram + '\'' +
                ", owner=" + owner +
                '}';
    }
}

