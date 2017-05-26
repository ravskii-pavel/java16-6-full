package core.entity;

import static core.entity.Gender.NOT_SPECIFIED;
import static core.entity.Lang.EN;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class UserDetails {

  private String firstName;
  private String lastName;
  private int age;

  @Enumerated(EnumType.STRING)
  private Gender gender = NOT_SPECIFIED;
  @Enumerated(EnumType.STRING)
  private Lang lang = EN;

  private String phoneNumber;
}
