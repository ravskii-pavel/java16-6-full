package ua.com.tickets.core.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

/*    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hall", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<MovieSession> movieSessions;*/

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hall", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Row> rowList;

    public Hall(int quantityRows, int quantitySeatsInRow) {
        this.quantityRows = quantityRows;
    }
    public Hall(String hallName, int quantityRows) {
        this.hallName = hallName;
        this.quantityRows = quantityRows;
    }
    public Hall(String hallName, List<Row> rowList) {
        this.hallName = hallName;
        this.rowList = rowList;
    }
}