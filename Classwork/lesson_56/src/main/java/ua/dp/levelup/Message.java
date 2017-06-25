package ua.dp.levelup;

/**
 * Created by java on 20.06.2017.
 */
public class Message {
    private String message;

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void print(){
        System.out.println(message);
    }
}
