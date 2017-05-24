package web.entity;

import lombok.*;


import javax.persistence.*;
/**
 * Created by Ravskiy Pavel on 21.05.2017.
 */

@Entity
@Table(name = "users", indexes = {
        @Index(columnList = "id, login, email", name = "user_idx")
})
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

/*    @Column(table = "EMPLOYEE_DETAILS")
    @Enumerated(EnumType.STRING)
    private Sex sex = Sex.UNKNOWN;*/

    @Column(table = "users", name = "role", nullable = false)
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

    public String getLogin() { return login; }
    public void setLogin(String login){ this.login = login; }

    public String getFullName() {return fullName;}
    public void setFullName(String fullName) { this.fullName = fullName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}
