package ua.com.tickets.core.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@ToString(exclude = "seatList")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rows")
public class Row {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "number_row", nullable = false)
    private int numberRow;

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "row")
    @JsonBackReference
    private List<Seat> seatList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id", nullable = false)
    @JsonManagedReference
    private Hall hall;

    @Column(table = "rows", name = "type_row", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeRow typeRow;

    public Row(int numberRow, Hall hall) {
        this.numberRow = numberRow;
        this.hall = hall;
        this.typeRow = TypeRow.COMFORT;
    }
    public Row(int numberRow, TypeRow typeRow, Hall hall) {
        this.numberRow = numberRow;
        this.hall = hall;
        this.typeRow = typeRow;
    }
}
