package online.reservation.DaoImpl;

import online.reservation.dao.UserDao;
import online.reservation.model.User;
import online.reservation.model.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {


    private  SessionFactory sessionFactory;
    private Session session = null;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }




    public UserDaoImpl() {
    }



    @Override
    public int saveUser(User user) {

        User p = new User(user.getFirstname(), user.getLastname(),
                                user.getUsername(), user.getEmail(),
                                user.getPassword());

        user.setAuthenticated(true);
        user.setRole("user");
        session = sessionFactory.openSession();
        session.beginTransaction();
        int savedToDb = (int) session.save(p);
        session.getTransaction().commit();
        return savedToDb;
    }

    @Override
    public User login(String email, String password) {

        session = sessionFactory.openSession();

        session.beginTransaction();

        String hql = "From User WHERE email = :email AND password = :password AND isAuthenticated = false";

        User user = (User) session.createQuery(hql).setParameter("email", email).setParameter("password", password)
                .uniqueResult();

        if (user != null) {
            System.out.println("not null");
            return user;
        } else {
            System.out.println("null");
            return null;
        }
    }

    @Override
    public int doReservation(String reservationDate,String reservationTime,String availableSeats, long id, int dateId) {
        User u = new User();
        u.setUser_id(id);
        Reservation rsv = new Reservation();
        rsv.setReservationDate(reservationDate);
        rsv.setHourOfReservation(reservationTime);
        rsv.setAvailableSeats(availableSeats);

        session = sessionFactory.openSession();
        session.beginTransaction();

        int saveToDb = (int) session.save(u);

        session.getTransaction().commit();

        return saveToDb;

    }
}
