package ua.com.tickets.core.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.type.CalendarDateType;
import org.hibernate.type.CalendarTimeType;
import org.hibernate.type.CalendarType;

import javax.persistence.*;

/*@TypeDef(name = "calendarDataType", typeClass = CalendarDateType.class)*/
//@TypeDef(name = "calendarTimeType", typeClass = CalendarTimeType.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(name = "calendarType", typeClass = CalendarType.class)
@Entity
@Table(name = "movie_sessions")
public class MovieSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id", nullable = false)
    @JsonManagedReference
    private Film film;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hall_id", nullable = false)
    @JsonManagedReference
    private Hall hall;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movieSession", cascade = CascadeType.ALL)
    private List<Ticket> ticketList;

    @Type(type = "calendarType")
    private Calendar sessionStartDate;

    @Column(name = "comfortPrice", nullable = false)
    private int priceTicketComfort;

    @Column(name = "standardPrice", nullable = false)
    private int priceTicketStandard;

    public MovieSession(Film film, Calendar sessionStartDate, Hall hall, int priceTicketStandard, int priceTicketComfort) {
        this.film = film;
        this.sessionStartDate = sessionStartDate;
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
                ", hallNumber=" + hall +
                ", priceTicketComfort=" + priceTicketComfort +
                ", priceTicketStandard=" + priceTicketStandard +
                '}';
    }

}


//    @Temporal(TemporalType.TIMESTAMP)
//    private Calendar sessionStartDate;
//    @Type(type = "calendarDataType")
//    private Calendar sessionStartDate;
//
/*    @Type(type = "calendarTimeType")
    private Calendar sessionStartTime;*/
/*    @OneToMany(mappedBy = "movieSession")
    @JsonBackReference
    private Set<SessionSeat> sessionSeatSet;*/