package ua.dp.levelup;

/**
 * Created by java on 13.06.2017.
 */
public class Greeting {


    /*public Greeting() {  //если в контексте создавать зависимость через конструктор, то обязательно нужно объявить конструктор без параметров
    }
    /*
    public Greeting(String messege) {
        this.messege = messege;
    }*/


    private String messege;

    public Greeting() {
    }

    public Greeting(String messege) {
        this.messege = messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public void sayHello(){
        System.out.println(messege);
    }
}
