package online.reservation.service;

import online.reservation.model.Reservation;

import java.util.List;

public interface ReservationService {
    public List<Reservation> query(String nomSale);

    String getWelcomeMessage();

    String getHelloMessage(String user);
}
