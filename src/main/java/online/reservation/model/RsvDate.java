package online.reservation.model;

import javax.persistence.*;

@Entity
@Table(name = "rsvDate")
public class RsvDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateOfAppointment")
    private String appointmentDate;

    @Column(name = "timeOfAppointment")
    private String appointmentTime;

    @Column(name = "availableSeats")
    private Integer availableSeats;

    public RsvDate() {

    }

    public RsvDate(RsvDate rsvDate) {
        this.id = rsvDate.id;
        this.appointmentDate = rsvDate.appointmentDate;
        this.appointmentTime = rsvDate.appointmentTime;
        this.availableSeats = availableSeats;
    }

    public RsvDate(Long id, String appointmentDate, String appointmentTime, int availableSeats) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.availableSeats = availableSeats;
    }

    public RsvDate(String appointmentDate, String appointmentTime, int availableSeats) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.availableSeats = availableSeats;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "RsvDate{" +
                "id=" + id +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
