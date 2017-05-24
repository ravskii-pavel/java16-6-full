package web.entity;


import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;
/**
 * Created by Ravskiy Pavel on 21.05.2017.
 */

@Entity
@Table(name = "users", indexes = {
        @Index(columnList = "id, login, email", name = "user_idx")
})
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "age")
    private int age;

    @Column(name = "phone", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /*@Column(name = "STATUS_ID")
    @Enumerated(EnumType.ORDINAL )*/

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

/*    public User(String login, String fullName, int age, String phoneNumber, String email) {
        this.login = login;
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(String login, String fullName, int age, String phoneNumber, String email, Role role) {
        this.login = login;
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
    }*/

//    public User() {
//    }
}
