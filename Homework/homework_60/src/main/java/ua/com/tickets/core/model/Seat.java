package ua.com.tickets.core.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@ToString(exclude = "reservedSeatList")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "number_seat", nullable = false)
    private int numberSeat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "row_id", nullable = false)
    @JsonManagedReference
    private Row row;

    public Seat(int numberSeat, Row row) {
        this.numberSeat = numberSeat;
        this.row = row;
    }
    public Seat(int numberSeat) {
        this.numberSeat = numberSeat;
    }
}
