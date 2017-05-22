package web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ravskiy Pavel on 21.05.2017.
 */

@Entity
@Table(name = "roles")
public enum Role {
    ADMIN,
    GUEST;
}
