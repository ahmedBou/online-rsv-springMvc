package online.reservation.dao;

import online.reservation.model.User;
import online.reservation.model.Reservation;

public interface UserDao {

    public int saveUser(User user);

    User login(String email, String password);

    int doReservation(String reservationDate, String reservationTime, String availableSeats, long id, int dateId);

}