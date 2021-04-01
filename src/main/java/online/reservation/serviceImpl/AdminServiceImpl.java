package online.reservation.serviceImpl;

import online.reservation.dao.AdminDao;
import online.reservation.model.Reservation;
import online.reservation.model.RsvDate;
import online.reservation.model.User;
import online.reservation.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;


    @Override
    public List<User> getUsers() {
        List<User> usersList = adminDao.getUsers();
        return usersList;
    }

    @Override
    public int acceptUser(String id) {
        return 0;
    }

    @Override
    public int ignoreUser(String id) {
        return 0;
    }

    @Override
    public List<Reservation> getReservation() {
        return null;
    }

    @Override
    public int acceptReservation(Integer id, int rsvDateId) {
        return 0;
    }

    @Override
    public int createReservation(RsvDate rsvDate) {
        return 0;
    }

    @Override
    public void deleteRsvDate(int id) {

    }

    @Override
    public int ignoreReservation(Integer id) {
        return 0;
    }
}
