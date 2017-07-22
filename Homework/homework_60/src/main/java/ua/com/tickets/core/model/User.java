package ua.com.tickets.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
//@NamedEntityGraph(name = "graph.User.orderList",
//        attributeNodes = @NamedAttributeNode(value = "orderList", subgraph = "orderList"),
//        subgraphs = @NamedSubgraph(name = "orderList", attributeNodes = @NamedAttributeNode("user")))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phoneNumber", nullable = false, unique = true)
    private String phoneNumber;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orderList;

    @Column(table = "users", name = "roleUser", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role roleUser;

    public User(String fullName, String email, String password, String phoneNumber, Role roleUser) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.roleUser = roleUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
