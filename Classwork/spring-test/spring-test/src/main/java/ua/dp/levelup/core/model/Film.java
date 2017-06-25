package ua.dp.levelup.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**

 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FILMS")
public class Film {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long filmId;
  private String name;
  private String description;
  private double duration;

  public Film(String name, String description, double duration) {
    this.name = name;
    this.description = description;
    this.duration = duration;
  }
}
