package online.reservation.service;

import online.reservation.model.RsvDate;
import online.reservation.model.User;

public interface UserService {

    public int saveUser(User user);

    User login(String email, String password);

    int doReservation(RsvDate date, long id, int dateId);

    boolean validateSignup(User user);

    boolean validateRsv(RsvDate date);

    boolean validateLogin(String email, String password);

}
