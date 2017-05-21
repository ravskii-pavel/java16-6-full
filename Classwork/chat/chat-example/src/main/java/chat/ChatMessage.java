package chat;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
  private String message;
  private String sender;
  private Date received;

  // getter, setter, toString omitted..
}
