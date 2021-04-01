package online.reservation.serviceImpl;

import online.reservation.dao.UserDao;
import online.reservation.model.RsvDate;
import online.reservation.model.User;
import online.reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDAO;

    @Override
    public int saveUser(User user) {
        if (this.validateSignup(user)) {
            int saveToDb = userDAO.saveUser(user);
            return saveToDb;
        } else {
            return 0;
        }
    }

    @Override
    public User login(String email, String password) {
        if (validateLogin(email, password)) {
            return userDAO.login(email, password);
        } else {
            return null;
        }
    }

    @Override
    public int doReservation(RsvDate date, long id, int dateId) {
        String appointmentDate;
        String appointmentTime;
        String availableSeats;

        try {
            if (this.validateRsv(date)) {
                String str = date.getAppointmentDate() ;
                String[] arrOfStr = str.split(",");
                appointmentDate = arrOfStr[0];
                appointmentTime = date.getAppointmentTime();
                availableSeats = date.getAvailableSeats().toString();

                int saveToDb = userDAO.doReservation(appointmentDate, appointmentTime, availableSeats, id, dateId);
                return saveToDb;
            } else {
                return 0;
            }
        }catch(NullPointerException nl) {
            return 0;
        }
    }

    @Override
    public boolean validateSignup(User user) {
        if (!(user.getFirstname() == "" && user.getLastname() == "" && user.getEmail()== ""
                && user.getPassword()=="")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean validateRsv(RsvDate date) {
        if (date.getAppointmentDate() != null && date.getAppointmentTime() != null && date.getAvailableSeats()!= null) {
            if (!(date.getAppointmentDate()=="" && date.getAppointmentTime()==""
                    && date.getAvailableSeats() != 0)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean validateLogin(String email, String password) {
        if (email != null && password != null && !(email=="" && password==""))
            return true;
        return false;
    }
}
