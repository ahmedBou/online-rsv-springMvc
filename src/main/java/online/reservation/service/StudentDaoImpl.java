package online.reservation.service;

import online.reservation.dao.StudentDao;
import online.reservation.model.Student;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Primary
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public StudentDaoImpl() {
    }

    public StudentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Student> list() {
        @SuppressWarnings("unchecked")
        List<Student> listUser = (List<Student>) sessionFactory.getCurrentSession()
                .createCriteria(Student.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }

    @Override
    @Transactional
    public Student get(int id) {

        String hql = "from Student where studentId=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<Student> listStudent = (List<Student>) query.list();

        if (listStudent != null && !listStudent.isEmpty()) {
            return listStudent.get(0);
        }

        return null;
    }

    @Override
    public void saveOrUpdate(Student student) {
        sessionFactory.getCurrentSession().saveOrUpdate(student);
    }

    @Override
    public void delete(int id) {

        Student userToDelete = new Student();
        userToDelete.setId((long) id);
        sessionFactory.getCurrentSession().delete(userToDelete);

    }
}
