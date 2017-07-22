package ua.com.tickets.core.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "number")
    private long number;

    @Column(name = "price", nullable = false)
    private int price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "session_id")
    private MovieSession movieSession;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "row_id")
    private Row row;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    public Ticket(long number, int price, MovieSession movieSession, Order order, Seat seat, Row row) {
        this.number = number;
        this.price = price;
        this.movieSession = movieSession;
        this.order = order;
        this.seat = seat;
        this.row = row;
    }
    public Ticket(int price, MovieSession movieSession, Order order, Seat seat, Row row) {
        this.price = price;
        this.movieSession = movieSession;
        this.order = order;
        this.seat = seat;
        this.row = row;
    }
}
