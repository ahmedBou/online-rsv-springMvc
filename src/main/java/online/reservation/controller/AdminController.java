package online.reservation.controller;

import online.reservation.model.Reservation;
import online.reservation.model.RsvDate;
import online.reservation.model.User;
import online.reservation.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    private String isrsvCreated = null;

    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/admin")
    public String admin(Model model, HttpSession session) {
        List<User> usersList = adminService.getUsers();
        List<Reservation> reservationList = adminService.getReservation();

        model.addAttribute("users", usersList);
        model.addAttribute("reservation", reservationList);
        model.addAttribute("isrsvCreated", isrsvCreated);

        User user = (User) session.getAttribute("currentUser");


        if (user != null) {

            return "admin";
        } else {
            return "redirect:/";
        }

    }


    
    @PostMapping(value = "/acceptAppointment")
    public String acceptAppointment(Appointment appointment) {

        adminService.acceptAppointment(appointment.getId(), appointment.getUser().getEmail(), appointment.getDateId());

        return "redirect:/admin";
    }

    @PostMapping(value = "/rejectAppointment")
    public String rejectAppointment(Appointment appointment) {

        adminService.rejectAppointment(appointment.getId(), appointment.getUser().getEmail());

        return "redirect:/admin";
    }

    @PostMapping(value = "/createDate")
    public String createDate(RsvDate date) {

        int affectedRow = adminService.createReservation(date);

        if (affectedRow > 0) {
            isrsvCreated = "true";
        } else {
            isrsvCreated = "false";
        }

        return "redirect:/admin";
    }

}
