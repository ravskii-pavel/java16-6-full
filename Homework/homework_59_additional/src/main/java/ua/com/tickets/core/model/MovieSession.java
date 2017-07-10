package ua.com.tickets.core.model;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.type.CalendarDateType;
import org.hibernate.type.CalendarTimeType;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(name = "calendarDataType", typeClass = CalendarDateType.class)
@TypeDef(name = "calendarTimeType", typeClass = CalendarTimeType.class)
@Entity
@Table(name = "movie_sessions")
public class MovieSession{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall hall;

    @Type(type = "calendarDataType")
    private Calendar sessionStartDate;

    @Type(type = "calendarTimeType")
    private Calendar sessionStartTime;

    @OneToMany(mappedBy = "movieSession")
    private List<ReservedSeat> reservedSeatList;

    @Column(name = "comfortPrice", nullable = false)
    private int priceTicketComfort;

    @Column(name = "standardPrice", nullable = false)
    private int priceTicketStandard;

    public MovieSession(Film film, Calendar sessionStartDate, Calendar sessionStartTime, Hall hall, int priceTicketComfort, int priceTicketStandard) {
        this.film = film;
        this.sessionStartDate = sessionStartDate;
        this.sessionStartTime = sessionStartTime;
        this.hall = hall;
        this.priceTicketComfort = priceTicketComfort;
        this.priceTicketStandard = priceTicketStandard;
    }

    @Override
    public String toString() {
        return "MovieSession{" +
                "id=" + id +
                ", film=" + film +
                ", sessionStartDate=" + sessionStartDate +
                ", sessionStartTime=" + sessionStartTime +
                ", hallNumber=" + hall +
                ", priceTicketComfort=" + priceTicketComfort +
                ", priceTicketStandard=" + priceTicketStandard +
                '}';
    }
}

/*    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sessionTime", nullable = false)
    private Date sessionStartTime;*/


    /*    @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "sessionDate", nullable = false)
        private Date sessionStartDate;   */

    /*    @OneToMany(fetch = FetchType.EAGER, mappedBy = "movieSession", cascade = CascadeType.ALL)
    private List<Ticket> ticketList;*/
