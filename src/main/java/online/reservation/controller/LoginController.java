package online.reservation.controller;

import lombok.extern.slf4j.Slf4j;
import online.reservation.dao.StudentDao;
import online.reservation.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Slf4j
@Controller
public class LoginController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/")
    public ModelAndView handleRequest() throws Exception {
        List<Student> listStudent = studentDao.list();
        ModelAndView model = new ModelAndView("listStudent");
        model.addObject("studentList", listStudent);
        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newStudent() {
        ModelAndView model = new ModelAndView("StudentForm");
        model.addObject("student", new Student());
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editUser(HttpServletRequest request) {
        int studentId = Integer.parseInt(request.getParameter("id"));
        Student student = studentDao.get(studentId);
        ModelAndView model = new ModelAndView("UserForm");
        model.addObject("student", student);
        return model;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) {
        int studentId = Integer.parseInt(request.getParameter("id"));
        studentDao.delete(studentId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute Student student) {
        studentDao.saveOrUpdate(student);
        return new ModelAndView("redirect:/");
    }
}
