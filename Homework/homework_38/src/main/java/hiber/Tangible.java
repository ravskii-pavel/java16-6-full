package hiber;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "employee")
@Entity
@Table(name = "tangibles")
public class Tangible {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Type(type = "timestamp")
    @Column(name = "date_create")
    private Date dateCreate;

    @ManyToOne
    @JoinTable(name = "employees_tangibles",
            joinColumns = @JoinColumn(name="tangible_id"),
            inverseJoinColumns = @JoinColumn(name="employee_id")
    )
    private Employee employee;

    public Tangible(String title, double price, String description, Date dateCreate) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.dateCreate = dateCreate;
    }
}
