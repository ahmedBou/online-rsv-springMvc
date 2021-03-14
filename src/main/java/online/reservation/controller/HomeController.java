package online.reservation.controller;

import lombok.extern.slf4j.Slf4j;
import online.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
public class HomeController {

    @Autowired
    ReservationService rsvService;

    public HomeController(ReservationService rsvService) {
        this.rsvService = rsvService;
    }

    @GetMapping("home")
    public String home(@RequestParam String user, Model model){
        model.addAttribute("user", rsvService.getHelloMessage(user));
        log.info("model = {}", model);
        return "home";
    }
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() is called" );
        return rsvService.getWelcomeMessage();
    }
}