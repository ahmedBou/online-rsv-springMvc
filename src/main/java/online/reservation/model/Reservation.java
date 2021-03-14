package online.reservation.model;

import java.time.LocalDate;

public class Reservation {
    private String nomSalle;
    private LocalDate date;
    private int hour;
    private Student student;
    private Promotion promotion;
    // Constructors, Getters and Setters


    public String getnomSalle() {
        return nomSalle;
    }
    public Reservation(String nomSalle, LocalDate date, int hour, Student student, Promotion promotion) {
        super();
        this.nomSalle = nomSalle;
        this.date = date;
        this.hour = hour;
        this.student = student;
        this.promotion = promotion;
    }
    public void setnomSalle(String courtName) {
        this.nomSalle = courtName;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Promotion getPromotion() {
        return promotion;
    }
    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

}
