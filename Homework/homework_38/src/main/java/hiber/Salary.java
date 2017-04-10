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
@Table(name = "salaries_paid")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "salariesPaid")
    private List<Employee> employees;

    @Column(name = "salary")
    private double salary;

    @Type(type = "timestamp")
    @Column(name = "date_pay")
    private Date datePay;

    @Type(type = "timestamp")
    @Column(name = "date_create")
    private Date dateCreate;
}
