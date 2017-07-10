package ua.com.tickets.core.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "number_row", nullable = false)
    private int numberRow;

    @Column(name = "number_seat", nullable = false)
    private int numberSeat;

    @OneToMany(mappedBy = "seat")
    private List<ReservedSeat> reservedSeatList;

/*    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall hall;*/

}
