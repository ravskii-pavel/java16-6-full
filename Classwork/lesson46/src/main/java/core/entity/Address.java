package core.entity;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Shegeda Alexandr (https://www.luxoft.com).
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

  private String country;
  private String city;
  private String street;
  private String houseNumber;
  private String flatNumber;

}
