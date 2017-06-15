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
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "age")
    private int age;

    @Column(name = "phone", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false, unique = false)
    private String password;

    @Column(table = "users", name = "roleUser", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role roleUser; //нельзя использовать имя role - т.к. в СУБД это ключевое слово = (будет exception, данные в базу не попадут)

    @Column(table = "users", name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public User(String login, String fullName, int age, String phoneNumber, String email,
                String password, Role roleUser, Gender gender) {
        this.login = login;
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.roleUser = roleUser;
        this.gender = gender;
    }

    public User(String login, String fullName, int age, String phoneNumber, String email,
                String password, Gender gender) {
        this.login = login;
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }
    public User(String login, String fullName, int age, String phoneNumber, String email,
                String password) {
        this.login = login;
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }
    public User(long id, String login, String fullName, int age, String phoneNumber, String email,
                String password) {
        this.id = id;
        this.login = login;
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }
}
