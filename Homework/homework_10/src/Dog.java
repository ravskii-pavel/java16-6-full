/**
 * Created by Pavel on 08.12.2016.
 */
public class Dog extends Animal {

    String nickname;

    public Dog (String nickname) {
        this.nickname = nickname;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void movement() {
        System.out.println("Бегать");
    }
    public void name() {
        System.out.println(getNickname());
    }
    public void jump() {
        System.out.println("Прыгать");
    }
    public void bite() {
        System.out.println("Кусать");
    }
    public void barking() {
        System.out.println("Подать голос");
    }
}