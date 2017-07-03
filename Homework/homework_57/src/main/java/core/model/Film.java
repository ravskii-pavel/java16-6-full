package core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film", cascade = CascadeType.ALL)
    private List<MovieSession> sessionList;

    public Film(String name, String description, double duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Film{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", duration=" + duration +
            '}';
    }
}
