package hiber;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by java on 31.03.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "employees")
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String title;
    @Column(name = "date_create")
    private Date creationDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
    private List<Employee> employees;

    public Post(String title, Date creationDate) {
        this.title = title;
        this.creationDate = creationDate;
    }
}
