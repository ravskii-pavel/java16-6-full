package ua.com.tickets.core.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;


import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@ToString(exclude = "sessionList")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "films")
public class Film{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private double duration;

    //@JsonIgnore //@JsonIgnore выполняет аналогичные функции, но ниже аннотации предпочтительнее.
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film", cascade = CascadeType.ALL)
    private List<MovieSession> sessionList;

    public Film(String name, String description, double duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

/*    @Override
    public String toString() {
        return "Film{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", duration=" + duration +
            '}';
    }*/
//    @JsonManagedReference -> Manages the forward part of the reference and the fields marked by this annotation are the ones that get Serialised
//    @JsonBackReference -> Manages the reverse part of the reference and the fields/collections marked with this annotation are not serialised.
}
