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

    @Column(name = "number", nullable = false, unique = true)
    private long number;

    @Column(name = "price", nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movieSession_id", nullable = false)
    @JsonManagedReference
    private  MovieSession movieSession;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    int numberSeat;
    int numberRow;

    public Ticket(long number, MovieSession movieSession, Order order, int numberSeat, int numberRow) {
        this.number = number;
        this.movieSession = movieSession;
        this.order = order;
        this.numberSeat = numberSeat;
        this.numberRow = numberRow;
    }

    public Ticket(long number, MovieSession movieSession, Order order, int numberSeat, int numberRow, int price) {
        this.number = number;
        this.movieSession = movieSession;
        this.order = order;
        this.numberSeat = numberSeat;
        this.numberRow = numberRow;
        this.price = price;
    }
}
