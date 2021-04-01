package online.reservation.serviceImpl;

import online.reservation.dao.ReservationDao;
import online.reservation.model.RsvDate;
import online.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDao reservationDao;


    @Override
    public List<RsvDate> getAllRsvDates() {
        List<RsvDate> datesList = reservationDao.getAllRsvDates();
        return datesList;
    }
}
