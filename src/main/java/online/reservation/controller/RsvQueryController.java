package online.reservation.controller;

import online.reservation.model.Reservation;
import online.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class RsvQueryController {

    private final ReservationService reservationService;
    @Autowired
    // Wire service in constructor, available in application context
    public RsvQueryController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Controller will always look for a default GET method to call first, irrespective of name
    // In this case, named setupForm to ease identification
    @GetMapping("reservationQuery")
    public void setupForm() {
        // Method is void, therefore a default view by the URL is assumed (reservationQuery.jsp)
        // (i.e.@RequestMapping(/reservationQuery.jsp))
        // Based on resolver configuration the reservationQuery.jsp view
        // will be mapped to a JSP in /WEB-INF/jsp/reservationQuery.jsp.jsp
    }

    // Controller will always look for a default POST method irrespective of name
    // when a submission ocurrs on the URL (i.e.@RequestMapping(/reservationQuery.jsp))
    // In this case, named submitForm to ease identification
    @PostMapping
    // Submission will come with courtName field, also add Model to return results
    public String sumbitForm(@RequestParam("nomSalle") String nomSalle, Model model) {
        // Create reservation list
        List<Reservation> reservations = java.util.Collections.emptyList();
        // Make a query if parameter is not null
        if (nomSalle != null) {
            reservations = reservationService.query("nomSalle");
        }
        // Update model to include reservations
        model.addAttribute("reservations", reservations);
        // Return view as a string
        // Based on resolver configuration the reservationQuery.jsp view
        // will be mapped to a JSP in /WEB-INF/jsp/reservationQuery.jsp.jsp
        return "reservationQuery";
    }

}
