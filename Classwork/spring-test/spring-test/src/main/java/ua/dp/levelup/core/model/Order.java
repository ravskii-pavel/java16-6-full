package ua.dp.levelup.core.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

  private Long orderId;
  private List<Long> tickets;
  private double totalPrice;
  private Long clientId;

}
