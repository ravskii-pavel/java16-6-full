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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hall", cascade = CascadeType.ALL)
    private List<MovieSession> movieSessions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hall", cascade = CascadeType.ALL)
    private Set<Row> rowSet;

    public Hall(){
    }

    public Hall(int quantityRows, int quantitySeatsInRow) {
        this.quantityRows = quantityRows;
    }
    public Hall(String hallName, int quantityRows, int quantitySeatsInRow) {
        this.hallName = hallName;
        this.quantityRows = quantityRows;
    }

    public void setQuantityRows(int quantityRows) {
        this.quantityRows = quantityRows;
    }

    public void setHallName(String hallName) { this.hallName = hallName; }
}
