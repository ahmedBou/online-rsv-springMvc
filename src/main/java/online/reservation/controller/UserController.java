package online.reservation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import online.reservation.model.RsvDate;
import online.reservation.model.User;
import online.reservation.service.ReservationService;
import online.reservation.service.UserService;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReservationService reservationService;

    private String isSignedUp = null;
    private String isLoggedIn = null;
    private User currentUser = null;
    private String isReservation = null;

    @GetMapping(value = "/")
    public String home(Model model) {

        List<RsvDate> datesList = reservationService.getAllRsvDates();
        model.addAttribute("isSignedUp", isSignedUp);
        model.addAttribute("isLoggedIn", isLoggedIn);
        model.addAttribute("isAppointmentMade", isReservation);
        model.addAttribute("datesList", datesList);

        return "home";
    }

    @PostMapping(value = "/signup")
    public String signup(User user) {
        int affectedRow = userService.saveUser(user);

        if (affectedRow > 0) {
            isSignedUp = "true";
        } else {
            isSignedUp = "false";
        }

        return "redirect: /";
    }

    @PostMapping(value = "/login")
    public String login(Model model, User user, HttpSession session) {

        User theUser = userService.login(user.getEmail(), user.getPassword());

        if (theUser != null) {
            isLoggedIn = "true";
            this.currentUser = theUser;

            if (this.currentUser.getRole().equals("admin")) {
                //session.setAttribute("currentUser", this.currentUser);
                return "redirect:/admin";
            }

        } else {
            isLoggedIn = "false";
        }

        return "redirect:/";
    }
    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        isSignedUp = null;
        isLoggedIn = null;
        isReservation = null;
        currentUser = null;

        return "redirect:/";
    }
    @PostMapping(value = "/appointment")
    public String makeAppointment(RsvDate date) {

        try {
            if (currentUser != null) {
                String str = date.getAppointmentDate();
                String[] arrOfStr = str.split(",");

                int dateId = Integer.parseInt(arrOfStr[1].trim());

                int affectedRow = userService.doReservation(date, currentUser.getUser_id(), dateId);

                if (affectedRow > 0) {
                    isReservation = "true";
                } else {
                    isReservation = "false";
                }
            } else {
                isReservation = "false";
            }
        } catch(Exception e) {
            isReservation = "false";
        }
        return "redirect:/";
    }


}
