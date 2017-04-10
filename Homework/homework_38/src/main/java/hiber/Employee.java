package hiber;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by java on 31.03.2017.
 */

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name_first")
    private String firstName;

    @Column(name = "name_last")
    private String lastName;

    @Column(name = "name_second")
    private String secondName;

    @Column
    private double salary;

    @Type(type = "timestamp")
    @Column(name = "date_create")
    private Date creationDate = new Date();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "employee")
    private PhoneNumber phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Salary salariesPaid;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private WorkDay workDays;

    public Employee(String firstName, String lastName, String secondName, double salary, Department department, Post post) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.salary = salary;
        this.department = department;
        this.post = post;
    }


    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
