package ua.dp.levelup;

/**
 * Created by java on 13.06.2017.
 */
public class Greeting {

    private String messege;

    public Greeting() {
        //System.out.println("create Greeting");
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }
    public void sayHello(){
        System.out.println(messege);
    }
}