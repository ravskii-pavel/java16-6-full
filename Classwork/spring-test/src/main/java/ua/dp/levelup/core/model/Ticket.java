package ua.dp.levelup.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TICKETS")
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long ticketId;
  private double price;
  private long movieSessionId;
  @ManyToOne
  private Order order;

  public Ticket(double price, long movieSessionId, Order order) {
    this.price = price;
    this.movieSessionId = movieSessionId;
    this.order = order;
  }
}
