

import online.reservation.DaoImpl.UserDaoImpl;
import online.reservation.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class test {

    @Autowired
    private UserDaoImpl personDaoImpl;

    public test(UserDaoImpl personDaoImpl) {
        this.personDaoImpl = personDaoImpl;
    }

    User ahmed = new User("ahmed", "boutayeb", "citizen", "ahmed@gmail.com", "user");

}
