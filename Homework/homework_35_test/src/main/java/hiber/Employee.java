package hiber;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by java on 21.03.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name_first")
    private String nameFirst;

    @Column(name = "name_last")
    private String nameLast;

    @Column(name = "name_second")
    private String nameSecond;

    @Column(name = "salary")
    private long salary;

    @Column (name = "date_create")
    @Type (type = "timestamp")
    private Date date = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public Employee(String nameFirst, String nameLast, String nameSecond, long salary) {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.nameSecond = nameSecond;
        this.salary = salary;
    }

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id_empl=" + id_empl +
//                ", nameFirst='" + nameFirst + '\'' +
//                ", nameLast='" + nameLast + '\'' +
//                ", nameSecond='" + nameSecond + '\'' +
//                ", salary=" + salary +
//                ", date=" + date +
//                '}';
//    }
}
