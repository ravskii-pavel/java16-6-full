package ua.com.tickets.core.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table (name = "sessions_seats")
public class SessionSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "session_id")
    @JsonManagedReference
    private MovieSession movieSession;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @Column(table = "sessions_seats", name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusSeat statusSeat;

    @Column(name = "price_seat", nullable = false)
    private int priceSeat;

    public SessionSeat(MovieSession movieSession, Seat seat, StatusSeat statusSeat, int priceSeat) {
        this.movieSession = movieSession;
        this.seat = seat;
        this.statusSeat = statusSeat;
        this.priceSeat = priceSeat;
    }
}
