package ua.dp.levelup.core.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieSession {

  private Long movieSessionId;
  private long filmId;
  private Date sessionStartDate;
  private Date sessionStartTime;
  private int hallNumber;
  private double standardTicketPrice;
  private double comfortTicketPrice;

}
