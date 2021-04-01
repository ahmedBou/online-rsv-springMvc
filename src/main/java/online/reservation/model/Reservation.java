package online.reservation.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservation_id;

    @Column(name = "reservationDate")
    private String reservationDate;

    @Column(name="hourOfReservation")
    private String hourOfReservation;

    @Column(name = "availableSeats")
    private String availableSeats;

    @Column(name = "date_id")
    private int dateId;

    @Column(name = "isReserved")
    private boolean isReserved;

    @Column(name = "isAccepted")
    private boolean isAccepted;

    @ManyToOne
    private User user;


    // Constructors, Getters and Setters
    public Reservation() {

    }


    public Reservation(Long reservation_id, String reservationDate, String hourOfReservation, String availableSeats, int dateId, boolean isReserved, boolean isAccepted, User user) {
        this.reservation_id = reservation_id;
        this.reservationDate = reservationDate;
        this.hourOfReservation = hourOfReservation;
        this.availableSeats = availableSeats;
        this.dateId = dateId;
        this.isReserved = isReserved;
        this.isAccepted = isAccepted;
        this.user = user;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getHourOfReservation() {
        return hourOfReservation;
    }

    public void setHourOfReservation(String hourOfReservation) {
        this.hourOfReservation = hourOfReservation;
    }

    public String getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(String  availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getDateId() {
        return dateId;
    }

    public void setDateId(int dateId) {
        this.dateId = dateId;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationDate=" + reservationDate +
                ", hourOfReservation=" + hourOfReservation +
                ", availableSeats=" + availableSeats +
                '}';
    }



    }

