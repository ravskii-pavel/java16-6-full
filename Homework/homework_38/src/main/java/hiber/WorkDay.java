package hiber;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "employee")
@Entity
@Table(name = "working_days")
public class WorkDay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


    @Type(type = "timestamp")
    @Column(name = "date_start")
    private Date dateStart;

    @Type(type = "timestamp")
    @Column(name = "date_finish")
    private Date dateFinish;

    @Type(type = "timestamp")
    @Column(name = "date_create")
    private Date dateCreate;

    public WorkDay(Employee employee, Date dateStart, Date dateFinish, Date dateCreate) {
        this.employee = employee;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.dateCreate = dateCreate;
    }
}
