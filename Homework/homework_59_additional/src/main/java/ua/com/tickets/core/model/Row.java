package ua.com.tickets.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rows")
public class Row {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "number_row", nullable = false)
    private int numberRow;

    @OneToMany(mappedBy = "seat")
    private List<Seat> seatList;

    @OneToMany(mappedBy = "row")
    private List<ReservedSeat> reservedSeatList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall hall;

    @Column(table = "rows", name = "type_row", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeRow typeRow;
}
