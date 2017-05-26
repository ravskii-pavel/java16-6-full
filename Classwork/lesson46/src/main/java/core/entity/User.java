package core.entity;

import static core.entity.UserType.SIMPLE;

import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Shegeda Alexandr (https://www.luxoft.com).
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String login;
  private String password;
  private String email;

  @Enumerated(EnumType.STRING)
  private UserType userType = SIMPLE;

  @Embedded
  private Address address;
  @Embedded
  private UserDetails userDetails;

  @Temporal(value = TemporalType.TIMESTAMP)
  private final Date registrationDate = new Date();

  @Temporal(value = TemporalType.TIMESTAMP)
  private Date lastLogin = new Date();


}
