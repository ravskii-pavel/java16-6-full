package hiber;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "employees")
@Entity
@Table(name = "working_days")
public class WorkDay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workDays")
    private List<Employee> employees;

    @Type(type = "timestamp")
    @Column(name = "day_start")
    private Date dayStart;

    @Type(type = "timestamp")
    @Column(name = "day_finish")
    private Date dayFinish;

    @Type(type = "timestamp")
    @Column(name = "date_create")
    private Date dateCreate;

}
