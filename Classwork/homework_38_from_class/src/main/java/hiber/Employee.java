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
@SecondaryTable(name = "EMPLOYEE_DETAILS",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "id_employee"))
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

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "employee")
    private PhoneNumber phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Column(table = "EMPLOYEE_DETAILS")
    @Enumerated(EnumType.STRING)
    private Sex sex = Sex.UNKNOWN;

    @Column(table = "EMPLOYEE_DETAILS")
    private String city;

    @Column(table = "EMPLOYEE_DETAILS")
    private String streetName;

    @Column(table = "EMPLOYEE_DETAILS")
    private String zipCode;

    @Embedded
    private Car car;

    public Employee(String firstName, String lastName, String secondName, double salary, Department department, Post post) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.salary = salary;
        this.department = department;
        this.post = post;
    }
}
