package online.reservation.dao;

import online.reservation.model.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> list();

    public Student get(int id);

    public void saveOrUpdate(Student student);

    public void delete(int id);
}
