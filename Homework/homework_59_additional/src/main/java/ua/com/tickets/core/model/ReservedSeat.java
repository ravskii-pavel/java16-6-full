package ua.com.tickets.core.model;

import javax.persistence.*;

@Entity
@Table (name = "reserved_seats")
public class ReservedSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "session_id")
    private MovieSession movieSession;

    @ManyToOne()
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @ManyToOne()
    @JoinColumn(name = "row_id")
    private Row row;

    @OneToOne
    @JoinColumn(name = "ticked_id")
    private Ticket ticket;

    public ReservedSeat(MovieSession movieSession, Seat seat) {
        this.movieSession = movieSession;
        this.seat = seat;
    }
}
