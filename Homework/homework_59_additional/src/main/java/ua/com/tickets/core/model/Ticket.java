package ua.com.tickets.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    private ReservedSeat reservedSeat;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private int numberSeat;
    private int numberRow;

    public Ticket(long number, MovieSession movieSession, Order order, int numberSeat, int numberRow) {
        this.number = number;
        this.order = order;
        this.numberSeat = numberSeat;
        this.numberRow = numberRow;
    }

    public Ticket(long number, MovieSession movieSession, Order order, int numberSeat, int numberRow, int price) {
        this.number = number;
        this.order = order;
        this.numberSeat = numberSeat;
        this.numberRow = numberRow;
        this.price = price;
    }
}
