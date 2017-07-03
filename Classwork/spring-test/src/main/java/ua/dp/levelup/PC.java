package ua.dp.levelup;

/**
 * Created by java on 16.06.2017.
 */
public class PC {

    private String hdd;
    private String ram;
    private User owner;

    public PC() {
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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
