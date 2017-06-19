package hiber;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by java on 04.04.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "employee")
@Entity
@Table(name = "phone_numbers")

public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 15)
    private String number;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public PhoneNumber(String number, Employee employee) {
        this.number = number;
        this.employee = employee;
    }
}
