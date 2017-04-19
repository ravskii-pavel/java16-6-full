package hiber;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by java on 31.03.2017.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "employees")
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

    /*@OneToOne(fetch = FetchType.LAZY, mappedBy = "employee")
    private PhoneNumber phoneNumber;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Salary> salariesPaid;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private Set<WorkDay> workingDays;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Set<Tangible> tangibles;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "employees_courses",
            joinColumns = @JoinColumn(name="employee_id"),
            inverseJoinColumns = @JoinColumn(name="course_id")
    )
    private Set<Course> courses;


    public Employee(String firstName, String lastName, String secondName, double salary, Department department, Post post) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.salary = salary;
        this.department = department;
        this.post = post;
    }


   /* public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }*/
}
