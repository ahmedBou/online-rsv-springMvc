package online.reservation.model;

import online.reservation.DaoImpl.UserDaoImpl;
import online.reservation.dao.UserDao;

public class App {

    public static void main(String[] args) {

        //Person p = new Person("ahmed", "boutayeb", "citizen", "ahmed@gmail.com", "user", true);

       UserDao pImpl = new UserDaoImpl();

        //pImpl.savePersonne(p);

    }
}
