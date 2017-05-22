package web.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;
/**
 * Created by Ravskiy Pavel on 21.05.2017.
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "age")
    private int age;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    /*@Column(name = "STATUS_ID")
    @Enumerated(EnumType.ORDINAL )*/

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role = Role.GUEST;

}
