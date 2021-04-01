package online.reservation.DaoImpl;

import online.reservation.dao.AdminDao;
import online.reservation.model.Reservation;
import online.reservation.model.RsvDate;
import online.reservation.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session = null;

    @Override
    public List<User> getUsers() {
        session = sessionFactory.openSession();

        session.beginTransaction();

        String hqlQuery = "From User WHERE isAuthenticated = true";

        List<User> usersList = session.createQuery(hqlQuery).getResultList();

        session.close();

        return usersList;

    }

    @Override
    public int acceptUser(String id) {
        String hqlUpdate = "UPDATE User SET isAuthenticated = false WHERE id = :id";

        session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery(hqlUpdate);
        query.setParameter("id", Integer.parseInt(id));

        int saveToDb = query.executeUpdate();
        session.getTransaction().commit();

        return saveToDb;

    }

    @Override
    public int ignoreUser(String id) {
        String hqlDelete = "DELETE FROM User WHERE id = :id";

        session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery(hqlDelete);
        query.setParameter("id", Integer.parseInt(id));

        int affectedRows = query.executeUpdate();
        session.getTransaction().commit();

        return affectedRows;
    }

    @Override
    public List<Reservation> getReservation() {
        String hql = "FROM Reservation AS a WHERE a.isAccepted != true";

        session = sessionFactory.openSession();

        session.beginTransaction();

        List<Reservation> rsv = session.createQuery(hql).getResultList();

        session.close();

        return rsv;
    }

    @Override
    public int acceptReservation(Integer id, int rsvDateId) {
        deleteRsvDate(rsvDateId);

        String updateQuery = "UPDATE Reservation SET isAccepted = true WHERE id = :id";
        session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery(updateQuery);
        query.setParameter("id", id);

        int saveToDb = query.executeUpdate();
        session.getTransaction().commit();

        return saveToDb;
    }

    @Override
    public int createReservation(RsvDate rsvDate){
        String appointmentDate = rsvDate.getAppointmentDate();
        String appointmentTime = rsvDate.getAppointmentTime();
        int availableSeats = rsvDate.getAvailableSeats();

        RsvDate d = new RsvDate(appointmentDate, appointmentTime, availableSeats);

        session = sessionFactory.openSession();
        session.beginTransaction();

        int saveToDb = (int) session.save(d);

        session.getTransaction().commit();

        return saveToDb;

    }

    @Override
    public void deleteRsvDate(int id) {
        String deleteQuery = "DELETE FROM RsvDate WHERE id = :id";

        session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery(deleteQuery);
        query.setParameter("id", id);
        query.executeUpdate();

        session.getTransaction().commit();


    }

    @Override
    public int ignoreReservation(Integer id) {
        String deleteQuery = "DELETE FROM Reservation WHERE id = :id";

        session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery(deleteQuery);
        query.setParameter("id", id);

        int saveToDB = query.executeUpdate();
        session.getTransaction().commit();

        return saveToDB;
    }
}
