package web.entity;

import javax.persistence.*;

/**
 * Created by Ravskiy Pavel on 21.05.2017.
 */

@Entity
@Table(name = "roles")
public enum Role {
    @Column(name = "role_name")
    ADMIN,
    GUEST;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
}
