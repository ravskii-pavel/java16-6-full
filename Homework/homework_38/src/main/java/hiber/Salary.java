package hiber;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "employees")
@Entity
@Table(name = "salaries_paid")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Employee> employees;

    @Column(name = "salary")
    private double salary;

    @Type(type = "timestamp")
    @Column(name = "date_pay")
    private Date datePay;

    @Type(type = "timestamp")
    @Column(name = "date_create")
    private Date dateCreate;

    public Salary(List<Employee> employees, double salary, Date datePay, Date dateCreate) {
        this.employees = employees;
        this.salary = salary;
        this.datePay = datePay;
        this.dateCreate = dateCreate;
    }
}
