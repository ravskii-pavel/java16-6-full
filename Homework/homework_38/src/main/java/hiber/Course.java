package hiber;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    private double hours;

    @Type(type = "timestamp")
    @Column(name = "date_create")
    private Date dateCreate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
    private List<Employee> employees;
}
