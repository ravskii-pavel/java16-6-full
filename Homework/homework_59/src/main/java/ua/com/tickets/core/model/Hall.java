package ua.com.tickets.core.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name = "halls")
public class Hall{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "hall_name", nullable = false, unique = true)
    private String hallName;

    @Column(name = "quantity_rows", nullable = false)
    private int quantityRows;

    @Column(name = "quantity_seats_rows", nullable = false)
    private int quantitySeatsInRow;

    @Column(name = "total_seats", nullable = false)
    private int totalSeats;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hall", cascade = CascadeType.ALL)
    private List<MovieSession> movieSessions;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hall", cascade = CascadeType.ALL)
    private Set<Seat> seatSet;

    public Hall(){
        this.quantityRows = 10;
        this.quantitySeatsInRow = 10;
        this.totalSeats = quantityRows * quantitySeatsInRow;
    }

    public Hall(int quantityRows, int quantitySeatsInRow) {
        this.quantityRows = quantityRows;
        this.quantitySeatsInRow = quantitySeatsInRow;
        this.totalSeats = quantityRows * quantitySeatsInRow;
    }
    public Hall(String hallName, int quantityRows, int quantitySeatsInRow) {
        this.hallName = hallName;
        this.quantityRows = quantityRows;
        this.quantitySeatsInRow = quantitySeatsInRow;
        this.totalSeats = quantityRows * quantitySeatsInRow;
    }

    public void setQuantityRows(int quantityRows) {
        this.quantityRows = quantityRows;
        this.totalSeats = quantityRows * quantitySeatsInRow;
    }

    public void setQuantitySeatsInRow(int quantitySeatsInRow) {
        this.quantitySeatsInRow = quantitySeatsInRow;
        this.totalSeats = quantityRows * quantitySeatsInRow;
    }

    public void setHallName(String hallName) { this.hallName = hallName; }
}
