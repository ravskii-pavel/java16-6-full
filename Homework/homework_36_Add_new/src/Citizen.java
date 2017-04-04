/**
 * Created by java on 21.03.2017.
 */
public class Citizen {

    long id;
    String first_name;
    String last_name;
    int age;
    String email;
    long street_id;


    public Citizen(String first_name, String last_name, int age, long street_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.street_id = street_id;
    }

    public Citizen(String first_name, String last_name, String email, int age, long street_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.age = age;
        this.street_id = street_id;
    }
    public Citizen(long id, String first_name, String last_name, String email, int age, long street_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.age = age;
        this.street_id = street_id;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getStreet_id() {
        return street_id;
    }

    public void setStreet_id(long street_id) {
        this.street_id = street_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", street_id=" + street_id +
                '}';
    }
}
