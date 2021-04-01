package online.reservation.dao;

import online.reservation.model.Reservation;
import online.reservation.model.RsvDate;
import online.reservation.model.User;

import java.util.List;

public interface AdminDao {
    List<User> getUsers();

    int acceptUser(String id);

    int ignoreUser(String id);

    List<Reservation> getReservation();

    int acceptReservation(Integer id, int rsvDateId);
    int createReservation(RsvDate rsvDate);

    void deleteRsvDate(int id);

    int ignoreReservation(Integer id);


}
