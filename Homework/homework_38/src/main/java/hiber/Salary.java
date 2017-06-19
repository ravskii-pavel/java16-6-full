package hiber;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "employee")
@Entity
@Table(name = "salaries_paid")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "salary")
    private double salary;

    @Type(type = "timestamp")
    @Column(name = "date_pay")
    private Date datePay;

    @Type(type = "timestamp")
    @Column(name = "date_create")
    private Date dateCreate;

    public Salary(Employee employees, double salary, Date datePay, Date dateCreate) {
        this.employee = employees;
        this.salary = salary;
        this.datePay = datePay;
        this.dateCreate = dateCreate;
    }
}
