package chat;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.websocket.Session;

public class Clients {

  public static final List<Session> sessionSet = new CopyOnWriteArrayList<>();

}
