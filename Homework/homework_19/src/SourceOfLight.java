/**
 * Created by Ravskiy Pavel on 19.01.2017.
 */
public interface SourceOfLight {
    void turnOn(boolean isTurnedOn, int voltage);
    //public void calculateLifeTime();
    void isItWorks();
    void showName();
    String getName();
}
