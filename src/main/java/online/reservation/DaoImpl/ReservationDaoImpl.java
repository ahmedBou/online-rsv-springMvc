package online.reservation.DaoImpl;

import online.reservation.dao.ReservationDao;
import online.reservation.model.RsvDate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationDaoImpl implements ReservationDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session = null;
    @Override
    public List<RsvDate> getAllRsvDates() {
        session = sessionFactory.openSession();

        session.beginTransaction();

        String hqlQuery = "From RsvDate";

        List<RsvDate> rsvDateList = session.createQuery(hqlQuery).getResultList();

        session.close();

        return rsvDateList;
    }
}
