package online.reservation.service;

import online.reservation.model.Promotion;
import online.reservation.model.Reservation;
import online.reservation.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService{

    public static final Promotion maryJackson= new Promotion(1, "maryJackson");
    public static final Promotion alainTurrein= new Promotion(2, "alainTurrein");

    private final List<Reservation> reservations = new ArrayList<>();

    public ReservationServiceImpl() {
        super();
        // TODO Auto-generated constructor stub
        reservations.add(new Reservation("Marry Jackson", LocalDate.of(2021, 03, 11), 16,
                new Student("Ahmed", "ahmed@gmail.com"), maryJackson));
    }

    @Override
    public List<Reservation> query(String nomSalle) {
        // TODO Auto-generated method stub
        return this.reservations.stream()
                .filter(reservation -> Objects.equals(reservation.getnomSalle(), nomSalle))
                .collect(Collectors.toList());
    }

    @Override
    public String getWelcomeMessage() {
        return "welcome to this demo";
    }

    @Override
    public String getHelloMessage(String user){
        return "hello"+ user;
    }



}
